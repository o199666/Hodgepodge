package com.cwj.video.activity

import android.os.Bundle
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.video.R
import com.cwj.video.databinding.ActivityVideoBinding
import com.cwj.video.fragment.VideoFragment
import com.cwj.video.vm.VideoViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   : 视频
 */
class VideoActivity(override val viewModel: BaseViewModel=VideoViewModel()) : BaseActivity<ActivityVideoBinding, VideoViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transation = supportFragmentManager.beginTransaction()
        transation.add(R.id.fragmentlayout,VideoFragment())
        transation.commit()
    }


}

 