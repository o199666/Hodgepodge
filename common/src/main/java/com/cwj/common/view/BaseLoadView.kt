package com.cwj.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.cwj.common.R

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/28
 *  desc   : 网络加载loading
 */
class BaseLoadView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        initView()
    }
    fun initView(){
        val view = View.inflate(context,
            R.layout.baseload_view, this)

    }



    /**
     * 为指定View设置宽高。
     */
      fun setWidthHeight(view: View, width: Int,height:Int) {
        //取控件当前的布局参数
        val params =
            view.layoutParams
        //设置宽度值
        params.width = width
        //设置高度值
        params.height = height
//使设置好的布局参数应用到控件
        view.layoutParams = params
    }
}

 