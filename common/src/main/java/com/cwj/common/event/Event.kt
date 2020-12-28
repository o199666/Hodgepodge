package com.cwj.common.event

import org.greenrobot.eventbus.EventBus

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/29
 *  desc   :
 */
object Event {
    fun getInstance(): EventBus {
        return EventBus.getDefault()
    }
}