package com.cwj.main.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.main.R
import com.cwj.main.databinding.MyFragmentBinding
import com.cwj.main.vm.MainViewModel
import com.cwj.main.vm.MyViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/17
 *  desc   :
 */
class MyFragment(
    override val layoutId: Int = R.layout.my_fragment,
    override val viewModel: BaseViewModel = MyViewModel()
) : BaseFragment<MyFragmentBinding, MyViewModel>() {
    override fun lazyLoadData() {
        Log.e("lazyLoadDate:My","111")
        vm.queryNewType(true)

        vm.resultData.observe(this, Observer {
            bd!!.dataTv.text= it[1].news_type_name

        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun initVD() {

    }

    fun newInstance(): MyFragment? {
        return MyFragment()
    }
}

 