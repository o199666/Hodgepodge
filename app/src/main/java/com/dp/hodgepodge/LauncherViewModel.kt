package com.dp.hodgepodge

import androidx.lifecycle.MutableLiveData
import com.cwj.common.base.BaseViewModel
import com.cwj.common.bean.news.NewsType
import com.cwj.common.net.apiservice

class LauncherViewModel:BaseViewModel() {
    val resultData: MutableLiveData<List<NewsType>> by lazy {
        MutableLiveData<List<NewsType>>()
    }
    /**
     * 查询类型
     */
    fun queryNewType(isShowLoading: Boolean) {
        launch(
            {
                Thread.sleep(2000)
                apiservice.queryNewsType()
            },
            resultData, isShowLoading
        )
    }
}