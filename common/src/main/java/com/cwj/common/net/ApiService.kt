package com.cwj.common.net

import com.cwj.common.bean.BaseBean
import com.cwj.common.bean.news.NewsType
import retrofit2.http.GET
/**
 * 请求的接口
 */
val apiservice by lazy {
    RetrofitUtils.INSTANCE.initRetrofit() }

interface Apiservice {

    @GET("news/queryNewsType")
    suspend fun queryNewsType(): BaseBean<List<NewsType>>

}