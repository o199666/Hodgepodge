package com.cwj.news.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cwj.common.base.BaseApplication
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.common.utils.ToastUtil
import com.cwj.news.R
import com.cwj.news.databinding.FragmentNewsBinding
import com.cwj.news.vm.NewsViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/9
 *  desc   :新闻
 */
class NewsFragment(override val viewModel: BaseViewModel = NewsViewModel()) :
    BaseFragment<FragmentNewsBinding, NewsViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_news

    override fun initVD() {
        vm.queryNewType(true)

//        vm.isShowLoading.observe(this  , Observer {
//            if (it) showLoading() else dismissLoding()
//        })
//        //错误信息
//        vm.errorData.observe(this, Observer {
//            if (it.show) ToastUtil.showToast(BaseApplication.mContext, it.errMsg)
//            errorResult(it)
//        })

        vm.resultData.observe(this, Observer {
            bd.tv.text = it[0].news_type_name
        })
    }

//    override fun regVideModel() {
//        vm = ViewModelProvider(this).get(NewsViewModel::class.java)
//    }

    override fun lazyLoadData() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(vm!=null){
            vm.queryNewType(true)

        }

    }

    open var loadingDialog: ProgressDialog? = null

    open fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = ProgressDialog(BaseApplication.getContext())
        }
        loadingDialog!!.show()
    }

    open fun dismissLoding() {
        loadingDialog?.dismiss()
        loadingDialog = null
    }
}

 