package com.cwj.common.event

import org.greenrobot.eventbus.EventBus

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/29
 *  desc   :
 */
object EventBusUtils {

    /**
     * 注册 EventBus
     * @param subscriber 订阅者
     */
    fun register(subscriber: Any?) {
        val eventBus: EventBus = EventBus.getDefault()
        if (!eventBus.isRegistered(subscriber)) {
            eventBus.register(subscriber)
        }
    }

    /**
     * 解绑 EventBus
     * @param subscriber 订阅者
     */
    fun unregister(subscriber: Any?) {
        val eventBus: EventBus = EventBus.getDefault()
        if (eventBus.isRegistered(subscriber)) {
            eventBus.unregister(subscriber)
        }
    }

    // =========
    // = Event =
    // =========

    // =========
    // = Event =
    // =========
    /**
     * 发送事件消息
     * @param event Event
     */
    fun post(event: Any?) {
        EventBus.getDefault().post(event)
    }

    /**
     * 取消事件传送
     * @param event Event
     */
    fun cancelEventDelivery(event: Any?) {
        EventBus.getDefault().cancelEventDelivery(event)
    }

    // =

    // =
    /**
     * 发送粘性事件消息
     * @param event Event
     */
    fun postSticky(event: Any?) {
        EventBus.getDefault().postSticky(event)
    }

    /**
     * 移除指定的粘性订阅事件
     * @param eventType Event Type
     * @param <T>       泛型
    </T> */
    fun <T> removeStickyEvent(eventType: Class<T>?) {
        val stickyEvent: T = EventBus.getDefault().getStickyEvent(eventType)
        if (stickyEvent != null) {
            EventBus.getDefault().removeStickyEvent(stickyEvent)
        }
    }

    /**
     * 移除所有的粘性订阅事件
     */
    fun removeAllStickyEvents() {
        EventBus.getDefault().removeAllStickyEvents()
    }
}