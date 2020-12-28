package com.cwj.common.bean

import com.cwj.common.bean.news.NewsType

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/26
 *  desc   : 所有的基类。
 */
class BaseBean<T>(
    var code: Int,
    var msg: String,
    var data: T?
)

 