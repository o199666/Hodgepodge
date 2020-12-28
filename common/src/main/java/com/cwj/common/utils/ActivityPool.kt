package com.cwj.common.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.*

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/25
 *  desc   :管理activity
 */
object  ActivityPool : Application.ActivityLifecycleCallbacks {
    private val activityStack = Stack<Activity>()
    fun init(app: Application) {
        app.registerActivityLifecycleCallbacks(this)
    }
    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        activityStack.remove(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activityStack.add(activity)
    }

    override fun onActivityResumed(activity: Activity) {
    }

    /**
     * 获取倒数第二个 Activity
     *
     * @return
     * @return
     */
    fun getPenultimateActivity(currentActivity: Activity): Activity? {
        var activity: Activity? = null
        try {
            if (activityStack.size > 1) {
                activity = activityStack[activityStack.size - 2]

                if (currentActivity == activity) {
                    val index = activityStack.indexOf(currentActivity)
                    if (index > 0) {
                        // 处理内存泄漏或最后一个 Activity 正在 finishing 的情况
                        activity = activityStack[index - 1]
                    } else if (activityStack.size == 2) {
                        // 处理屏幕旋转后 activityStack 中顺序错乱
                        activity = activityStack.lastElement()
                    }
                }
            }
        } catch (e: Exception) {
        }
        return activity
    }

    /**
     * 获取栈底Activity
     */
    fun getLastActivity() = activityStack.lastElement()

    /**
     * 获取栈顶Activity
     */
    fun getCurrentActivity() = if (activityStack.isEmpty()) null else activityStack.firstElement()

    /**
     * 数量
     */
    fun size() = activityStack.size
}

 