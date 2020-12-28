package com.dp.hodgepodge.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.RequiresApi

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/20
 *  desc   : 熟悉 Canvas 和 Paint 的各个API
 */
@SuppressLint("AppCompatCustomView")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class Zi1(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {
    /**
     * 画笔：主要功能如下
     * 1，颜色
     * 2，
     */
    var paint = Paint()

    init {

    }

    /**
     * 总体调度
     */
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
//        所以如果把绘制代码写在 super.draw() 的下面，
//        那么这段代码会在其他所有绘制完成之后再执行，
//        也就是说，它的绘制内容会盖住其他的所有绘制内容。
    }

    /**
     * 绘制主体
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    /**
     * 绘制子view
     *  6217 9076 0000 1864 441
     */
    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        paint.color = Color.RED
        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawRect(0f, 20f, 150f, 100f, paint)
        //拿到字符串的宽度
        var text = "New"
        paint.strokeCap = Paint.Cap.BUTT
        paint.setColor(Color.WHITE)
        //居中
        paint.textSize = 50f
        paint.textAlign = Paint.Align.CENTER
        canvas!!.drawText(text, 70f, 150f / 2, paint)
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)

    }
}
