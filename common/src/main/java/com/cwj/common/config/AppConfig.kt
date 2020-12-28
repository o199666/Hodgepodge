package com.cwj.common.config

import android.content.Context

/**
 * 单例类 存放一些配置文件
 */
object AppConfig {
    val BaseUrl = "http://192.168.0.143:8080/"
    var TOKEN = "" //用户token
    var User_Agent = "" // ua


    //网络请求接口含义
    var HTTP_SUCCESS = 1000
    var HTTP_ERROR = -100

}