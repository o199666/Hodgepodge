@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.cwj.kotlin_jpk_basic.utlis

import android.content.Context
import android.os.Build
import android.webkit.WebSettings

/**
 * 获取用户UserAgent
 */
object UserAgentUtils {

    /**
     * 获取UserAgent
     */
    fun getUserAgent(context: Context): String {
        val userAgent: String
        var sb: StringBuffer? = null
        try {
            userAgent = (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                try {
                    WebSettings.getDefaultUserAgent(context)
                } catch (e: Exception) {
                    System.getProperty("http.agent")
                }
            } else {
                System.getProperty("http.agent")
            }).toString()
            sb = StringBuffer()
            var i = 0
            val length = userAgent.length
            while (i < length) {
                val c = userAgent[i]
                if (c <= '\u001f' || c >= '\u007f') {
                    sb.append(String.format("\\u%04x", c.toInt()))
                } else {
                    sb.append(c)
                }
                i++
            }
        } catch (e: Exception) {
//            LogUtlis.e("获取手机UA异常 $e")
        }
        val result = sb.toString()
//        LogUtlis.e("UserAgent ===> : $result")
        return result
    }

}