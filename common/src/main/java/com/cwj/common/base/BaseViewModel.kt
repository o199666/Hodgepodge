package com.cwj.common.base

import android.app.Application
import androidx.lifecycle.*
import com.byl.mvvm.api.error.ErrorResult
import com.cwj.common.bean.BaseBean
import com.cwj.common.config.AppConfig
import com.cwj.common.net.error.ErrorUtil
import com.orhanobut.logger.Logger
import kotlinx.coroutines.*


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/30
 *  desc   : 封装 ViewModel  添加 周期监听
 */
open class BaseViewModel : ViewModel(), ViewModelLifecycle {
    lateinit var lifcycleOwner: LifecycleOwner
    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        this.lifcycleOwner = owner
    }

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }

    var errorData = MutableLiveData<ErrorResult>()//错误信息
    var isShowLoading = MutableLiveData<Boolean>()//是否显示loading

    private fun showLoading() {
        isShowLoading.value = true
    }

    private fun dismissLoading() {
        isShowLoading.value = false
    }

    private fun showError(error: ErrorResult) {
        errorData.value = error
    }

    /**
     * 封装网络请求
     */
    fun <T> launch(
        block: suspend CoroutineScope.() -> BaseBean<T>,//请求接口方法，T表示data实体泛型，调用时可将data对应的bean传入即可
        liveData: MutableLiveData<T>,   // 要发送到Activity的数据
        isShowLoading: Boolean = false, // 是否要打开Loading
        isShowError: Boolean = true     // 是否显示错误
    ) {
        if (isShowLoading)
            viewModelScope.launch {
                try {
                    val result = withContext(Dispatchers.IO) {
                        block()
                    }
                    if (result.code == AppConfig.HTTP_SUCCESS) { //请求成功  这里后台协商
                        liveData.value = result.data
                    } else {
                        Logger.e("请求错误>>" + result.code)
                        showError(ErrorResult(result.code, result.msg, isShowError))
                    }
                } catch (e: Throwable) {//接口请求失败
                    Logger.e("请求异常>>" + e.message)
                    val errorResult = ErrorUtil.getError(e)
                    errorResult.show = isShowError
                    showError(errorResult)
                } finally {//请求结束
                dismissLoading()
                }
            }
    }


    //释放
    override fun onCleared() {
        super.onCleared()
    }


//
//    //需要并行的时候这样用 合并
//    GlobalScope.launch(Dispatchers.Main) {
//        val one = async { api.listReposKt("rengwuxian") }
//        val two = async { api.listReposKt("google") }
//        binding.tv.text = "${one.await()[0].name} -> ${two.await()[0].name}"
//    }
//    //其中一个作为另外一个参数
//    GlobalScope.launch(Dispatchers.Main) {
//        val one = api.listReposKt("rengwuxian")
//        val two = api.listReposKt(one[0].name)
////            binding.tv.text="${one.await()[0].name} -> ${two.await()[0].name}"
//    }
//
//
//    //
//    var scope = MainScope()
//    scope.launch(Dispatchers.Main) {
//        val one = async { api.listReposKt("rengwuxian") }
//        val two = async { api.listReposKt("google") }
//        binding.tv.text = "${one.await()[0].name} -> ${two.await()[0].name}"
//    }
//    //避免内存泄露。 取消，结构化
//    scope.cancel()
//
//
//    lifecycleScope.launch(Dispatchers.Main) {
//        val one = async { api.listReposKt("rengwuxian") }
//        val two = async { api.listReposKt("google") }
//        binding.tv.text = "${one.await()[0].name} -> ${two.await()[0].name}"
//    }
////在执行完created的时候 再执行。
//    lifecycleScope.launchWhenCreated {
//        val one = async { api.listReposKt("rengwuxian") }
//        val two = async { api.listReposKt("google") }
//        binding.tv.text = "${one.await()[0].name} -> ${two.await()[0].name}"
//    }
}

 