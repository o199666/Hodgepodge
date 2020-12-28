package com.cwj.common.bean.news

import java.io.Serializable

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/26
 *  desc   :
 */
data class NewsType(
    var news_type_desc: String,
    var news_type_id: Int,
    var news_type_name: String
):Serializable