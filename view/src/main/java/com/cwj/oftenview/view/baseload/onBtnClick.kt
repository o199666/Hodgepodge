package com.cwj.oftenview.view.baseload

import android.view.View

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/30
 *  desc   : 点击事件，
 */
interface onBtnClick {
    fun onClick(view:View,loadState: LoadState)
}