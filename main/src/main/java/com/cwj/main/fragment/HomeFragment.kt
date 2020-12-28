package com.cwj.main.fragment

import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.common.view.BaseLoadView
import com.cwj.main.R
import com.cwj.main.databinding.HomeFragmentBinding
import com.cwj.main.vm.HomeViewModel


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/17
 *  desc   :
 */
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    override fun lazyLoadData() {
        Log.e("lazyLoadDate:Home", "111")
    }

    fun newInstance(): HomeFragment? {
        return HomeFragment()
    }
    override fun initVD() {
        vm.queryNewType(true)
        vm.resultData.observe(this, Observer {
            bd!!.dataTv.text = it.get(0).news_type_name
        })
        val linearParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        var loadView= context?.let { BaseLoadView(it,null,0) }
        loadView!!.setWidthHeight(loadView, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)

        bd.cl.addView(loadView)

    }



    override val layoutId: Int
        get() = R.layout.home_fragment
    override val viewModel: BaseViewModel
        get() = HomeViewModel()
}

 