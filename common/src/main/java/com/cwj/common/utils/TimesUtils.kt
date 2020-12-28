package com.cwj.kotlin_jpk_basic.utlis

/**
 *  author : ChenWenJie
 * email  :1181620038@qq.com
 *  date   : 2020/7/28
 *  desc   : 时间相关工具类
 */
object TimesUtils {


    /**
     * 时间差
     * 发表时间
     */
       fun convert(startDate: Long): String? {
        var startTime = startDate//获取毫秒数
        var endTime = System.currentTimeMillis()     //获取毫秒数
        var timeDifference = endTime - startTime;
        var second = timeDifference / 1000;    //计算秒
        if (second < 60) {
            return "$second 秒前"
        } else {
            var minute = second / 60
            if (minute < 60) {
                return "$minute 分钟前"
            } else {
                var hour = minute / 60
                if (hour < 24) {
                    return "$hour 小时前"
                } else {
                    var day = hour / 24
                    if (day < 30) {
                        return "$day 天前"
                    } else {
                        var month = day / 30
                        if (month < 12) {
                            return "$month 月前"
                        } else {
                            var year = month / 12
                            return "$year 年前"
                        }
                    }

                }
            }
        }

    }
}