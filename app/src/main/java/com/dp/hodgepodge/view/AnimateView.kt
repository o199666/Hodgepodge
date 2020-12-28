package com.dp.hodgepodge.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.View

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/23
 *  desc   : 自定义view 之动画
 */
class AnimateView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    //画笔
    var paint = Paint()
    //起名字




    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
//        canvas?.drawArc(RectShape, 135f, progress * 2.7f, false, paint);

    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        canvas!!.drawCircle(200f,200f,150f,paint)
    }



}

 