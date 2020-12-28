package com.cwj.news.vm

import androidx.lifecycle.MutableLiveData
import com.cwj.common.base.BaseViewModel
import com.cwj.common.bean.BaseBean
import com.cwj.common.bean.news.NewsType
import com.cwj.common.net.apiservice
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep
import java.net.SocketTimeoutException

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/9
 *  desc   :
 */
class NewsViewModel : BaseViewModel() {
    val resultData: MutableLiveData<List<NewsType>> by lazy {
        MutableLiveData<List<NewsType>>()
    }
    /**
     * 假数据
     */


    /**
     * 查询类型
     */
    fun queryNewType(isShowLoading: Boolean) {
        launch(
            {
                sleep(2000)
                apiservice.queryNewsType()
            },
            resultData,
            isShowLoading
        )
    }

}

 