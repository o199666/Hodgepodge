package com.cwj.music.fragment

import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.music.R
import com.cwj.music.databinding.FragmentMusicBinding
import com.cwj.music.vm.MusicViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/9
 *  desc   : 音乐
 */
class MusicFragment(override val viewModel: BaseViewModel=MusicViewModel()) :BaseFragment<FragmentMusicBinding,MusicViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_music

    override fun initVD() {
    }



    override fun lazyLoadData() {

    }


}

 