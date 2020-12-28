package com.cwj.common.net

//import retrofit2.converter.scalars.ScalarsConverterFactory
import android.content.Context
import android.util.Log
import com.cwj.common.base.BaseApplication
import com.cwj.common.config.AppConfig
import com.cwj.common.config.AppConfig.TOKEN
import com.cwj.common.config.AppConfig.User_Agent
import com.cwj.common.utils.NetworkUtils
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.internal.cache.DiskLruCache
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.security.AccessController.getContext
import java.util.concurrent.TimeUnit

class RetrofitUtils {
    //单例
    companion object {
        val INSTANCE: RetrofitUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitUtils()
        }
    }

    /**
     * 初始化 retrofit
     */
    fun initRetrofit(): Apiservice {
        return Retrofit.Builder()
            //设置okttp ，不设置没影响。看需求
            .client(initOKHttp().build())
            //设置网络请求BaseUrl地址
            .baseUrl(AppConfig.BaseUrl)
            //设置数据解析器
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            //请求结果转换为基本类型
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(Apiservice::class.java)
    }

    /**
     * OKHTTP 相关配置
     */
    lateinit var cacheFile: File
    lateinit var cache: Cache
    fun initOKHttp(): OkHttpClient.Builder {
        try {
            cacheFile = File(BaseApplication.getContext()?.externalCacheDir, CACHE_NAME)
            cache = Cache(cacheFile, 1024 * 1024 * 50)
        } catch (e: Exception) {
            Log.d("OKHTTP--缓存--文件创建", e.message + "")
        }
        //配置日志拦截
        var loggingInterceptor = HttpLoggingInterceptor()
            // 日志级别
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpBuilder = OkHttpClient.Builder()
            //设置缓存
//            .cache(cache).addInterceptor(cacheInterceptor())
            .connectTimeout(4, TimeUnit.SECONDS)//链接超时为2秒，单位为秒
            .writeTimeout(4, TimeUnit.SECONDS)//写入超时
            .readTimeout(4, TimeUnit.SECONDS)//读取超时
            .addInterceptor(loggingInterceptor) //日志拦截
//            .sslSocketFactory(SSLContextSecurity.createIgnoreVerifySSL("TLS"))//证书配置

            //错误重连
            .retryOnConnectionFailure(true)
            //配置请求头
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        //设置请求token
                        .addHeader("token", TOKEN)
                        .removeHeader("User-Agent")
                        .addHeader("User-Agent", User_Agent)
                        .addHeader("Connection", "keep-alive")
                        .build()
                    return chain.proceed(request)
                }

            }).build()
        return okHttpBuilder.newBuilder()
    }

    /**
     * 可以根据实际需求，自己写获取token的方式 todo:
     */
    fun getToken() {

    }


    //========================================设置网络缓存 开始============================================
    var CACHE_NAME = "HTTP_CACHE" //缓存的名字

    /**
     * 缓存的拦截器
     */

    fun cacheInterceptor(): Interceptor {
        //声明 缓存
        val cacheInterceptor = Interceptor {
            var request: Request = it.request()
            if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()!!)) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
            }
            val response: Response = it.proceed(request)
            if (NetworkUtils.isNetworkAvailable(BaseApplication.getContext()!!)) {
                val maxAge = 0
                //有网络时设置网络超时时间0个小时
                response.newBuilder()
                    .header("Cache-Control", "public, max-age=$maxAge")
                    .removeHeader(CACHE_NAME)// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build()
            } else {
                // 无网络时，设置超时为4周
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .removeHeader(CACHE_NAME).build()
            }
            response
        }
        return cacheInterceptor
    }
}

 