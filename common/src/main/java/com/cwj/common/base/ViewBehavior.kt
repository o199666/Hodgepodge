package com.cwj.common.base

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/30
 *  desc   :
 */
interface ViewBehavior {
    /**
     * 是否显示Loading视图
     */
    fun showLoadingUI(isShow: Boolean)

    /**
     * 是否显示空白视图
     */
    fun showEmptyUI(isShow: Boolean)

    /**
     * 弹出Toast提示
     */
    fun showToast(map: Map<String, *>)

    /**
     * 不带参数的页面跳转
     */
    fun navigateTo(page: Any)

    /**
     * 返回键点击
     */
    fun backPress(arg: Any?);

    /**
     * 关闭页面
     */
    fun finishPage(arg: Any?)

}