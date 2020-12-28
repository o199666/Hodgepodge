package com.cwj.my.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.my.R
import com.cwj.my.databinding.FragmentMyBinding
import com.cwj.my.vm.MyViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/9
 *  desc   :
 */
class MyFragment(override val viewModel: BaseViewModel=MyViewModel()) :BaseFragment<FragmentMyBinding, MyViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_my

    @RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
    override fun initVD() {

    }



    override fun lazyLoadData() {

    }


}

 