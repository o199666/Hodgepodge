package com.cwj.music.activity

import android.os.Bundle
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.music.R
import com.cwj.music.databinding.ActivityMusicBinding
import com.cwj.music.fragment.MusicFragment
import com.cwj.music.vm.MusicViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   : 音乐模块主页
 */
class MusicActivity(override val layoutId: Int=R.layout.activity_music,
                    override val viewModel: BaseViewModel=MusicViewModel()
) : BaseActivity<ActivityMusicBinding, MusicViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transation = supportFragmentManager.beginTransaction()
        transation.add(R.id.fragmentlayout,MusicFragment())
        transation.commit()
    }



}

 