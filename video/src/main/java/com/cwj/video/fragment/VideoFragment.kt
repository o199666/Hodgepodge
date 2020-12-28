package com.cwj.video.fragment

import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.video.R
import com.cwj.video.databinding.FrgmentVideoBinding
import com.cwj.video.vm.VideoViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/9
 *  desc   :
 */
class VideoFragment(override val viewModel: BaseViewModel=VideoViewModel()) :BaseFragment<FrgmentVideoBinding,VideoViewModel>() {
    override val layoutId: Int
        get() = R.layout.frgment_video

    override fun initVD() {
    }



    override fun lazyLoadData() {

    }

}

 