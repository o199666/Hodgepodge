package com.cwj.common.base

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.cwj.common.utils.ActivityPool
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

import java.util.*


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/30
 *  desc   : 基类
 */

class BaseApplication : MultiDexApplication(), IApplication
     {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)//处理方法数超过65555
    }

    var isDebug = true

    companion object {
        var mContext: Application? = null
        fun getContext(): Context {
            return mContext!!
        }

    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        initARouter()
        inLog()
        //管理Activity
        ActivityPool.init(this)
    }


    //如果有其他页面的，就用这个
    override fun onCreate(application: Application?) {
//        loadModuleApp()
    }

    //初始化log
    fun inLog() {
        Logger.addLogAdapter(AndroidLogAdapter())
        //当 isLoggable 返回true时输出日志，否则不输出
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return true
            }
        })
    }

    //销毁 ,这个方法不一定会执行
    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
    // 当后台资源已经销毁时且资源还是匮乏时会调用。此方法一般释放不必要的资源。
    override fun onLowMemory() {
        super.onLowMemory()
    }
    //初始化 ,
    fun initARouter() {
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)// 尽可能早，推荐在Application中初始化
    }



    /**
     * 加载各个模块的Application，例如：推送和IM等模块都需要有Application，
     * 但组件化只能有一个Application，而且为了解耦各个模块不能互相引用，
     * 所以只能通过反射方式，把这些module_appliation进行初始化
     *
     * 其他模块的APP 需要的单独 初始化的。
     */
    private fun loadModuleApp() {
        for (moduleImpl in IApplication.Apps.MODULE_APP) {
            try {
                val clazz = Class.forName(moduleImpl)
                val obj = clazz.newInstance()
                if (obj is IApplication) {
                    (obj as IApplication).onCreate(this)
                }
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
        }
    }


}

 