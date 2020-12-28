package com.cwj.common.view

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/28
 *  desc   :加载状态
 */
enum class LoadState {
    LOADING,//加载中
    HIDE,//隐藏
    NET_WORK,//无网络
    EMPTY,//无数据
    NOLOGIN,//未登录
    NET_TIME,//请求超时
    ERROR,//请求错误
}