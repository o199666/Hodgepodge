package com.cwj.main.fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.common.utils.ToastUtil
import com.cwj.oftenview.view.baseload.BaseLoadView
import com.cwj.main.R
import com.cwj.main.databinding.HomeFragmentBinding
import com.cwj.main.vm.HomeViewModel
import com.cwj.oftenview.view.baseload.LoadState
import com.cwj.oftenview.view.baseload.onBtnClick
import kotlinx.coroutines.GlobalScope


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

    override fun initVD() {
        vm.queryNewType(true)
        vm.resultData.observe(this, Observer {
            bd.dataTv.text = it[0].news_type_name
        })

        //动态添加加载框，
        var loadView =
            BaseLoadView(this.requireContext())
//        loadView.setStete(LoadState.LOADING)
        bd.cl.addView(loadView)


        loadView.setOnBtnClick(object : onBtnClick {
            override fun onClick(view: View, loadState: LoadState) {
                //根据不同的状态，操作
                when(loadState){
                    LoadState.ERROR->{

                    }
                    LoadState.EMPTY->{

                    }
                    LoadState.NOLOGIN->{

                    }
                }
            }

        })


//        loadView.dismiss(loadView)
    }


    override val layoutId: Int
        get() = R.layout.home_fragment
    override val viewModel: BaseViewModel
        get() = HomeViewModel()
}

 