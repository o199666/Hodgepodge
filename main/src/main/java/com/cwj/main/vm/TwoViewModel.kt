package com.cwj.main.vm

import androidx.lifecycle.MutableLiveData
import com.cwj.common.base.BaseViewModel
import com.cwj.common.bean.news.NewsType
import com.cwj.common.net.apiservice

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/21
 *  desc   :
 */
open class TwoViewModel:BaseViewModel() {
    val resultData: MutableLiveData<List<NewsType>> by lazy {
        MutableLiveData<List<NewsType>>()
    }
    /**
     * 查询类型
     */
    fun queryNewType(isShowLoading: Boolean) {
        launch(
            {
                apiservice.queryNewsType()
            },
            resultData, isShowLoading
        )
    }
}

 