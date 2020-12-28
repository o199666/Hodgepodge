package com.cwj.common.base

import android.app.Application

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/30
 *  desc   : 支持多个Module—Application共存，
 *           module模块自定义的Application实现这个接口，然后把实现类的包名+类名写在下方常量中
 */
open interface IApplication {
    object Apps {
        var MODULE_APP = arrayOf(
            "com.vc.wd.push.core.PushApplication",
            "com.vc.wd.im.core.IMApplication"
        )
    }


    fun onCreate(application: Application?)
}