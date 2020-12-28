package com.cwj.oftenview.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.content.ContextCompat
import com.cwj.oftenview.R


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/11/26
 *  desc   : 滑动评分，像右边滑动
 *  背景， 前景滑块
 */
@SuppressLint("ResourceAsColor")
class SlideScoreView : View {
    //背景的颜色
    var bgPaint = Paint()

    //前面的颜色
    var proPaint = Paint()
    var bgTextPaint = Paint()
    var proTextPaint = Paint()

    init {

        bgPaint.strokeCap = Paint.Cap.ROUND
        bgPaint.isAntiAlias = true
        //设置绘制模式 STROKE:不填充，FILL:填充 ，FILL_AND_STROKE
        bgPaint.style = Paint.Style.FILL
        //设置颜色
        //设置线条宽度
        bgPaint.strokeWidth = 1f
        bgPaint.color = ContextCompat.getColor(context, R.color.gray)
        bgTextPaint.strokeWidth = 2f
        bgTextPaint.textSize = 40f
        bgTextPaint.color = ContextCompat.getColor(context, R.color.gray800)

//         设置重叠模式
//        var xf=PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
//        proPaint.setXfermode(xf)
        proPaint.strokeCap = Paint.Cap.ROUND;
        proPaint.color = Color.RED
        //背景颜色
        proTextPaint.strokeWidth = 2f
        proTextPaint.textSize = 40f
        proTextPaint.color = Color.WHITE


    }

    //两个矩形上下左右。边距
    var margin = dip2px(context, 5f).toFloat();
    //layout

    //外层矩形
    var left = 0f;
    var right = dip2px(context, 207f).toFloat()//207f
    var top = 0f;
    var bottom = dip2px(context, 40f).toFloat();//40f

    //内层矩形 首先确定 上 下位置是不变的。动态改变的只是左右。 所以左右需要根据触摸的位置的改变
    var left1 = left + margin
    var right1 = left1 //默认跟最开始得一样。
    var top1 = top + margin
    var bottom1 = bottom - margin;
    var arcMargin = dip2px(context, 10f).toFloat(); //圆弧

    //先得出进度条的长度
    var proRight = (right - margin) - (left + margin)

    //起始数字
    var startNum = 0;

    //总数
    var stopNum = 10;

    //当前数字
    var currentNum = 0

    //根据总数把视图分成平局 先计算进度的总长度：得到每份的宽度 ，用于后面计数使用
    var pjNum = proRight / stopNum

    fun jisuan(l:Int,t:Int,r:Int,b:Int){
        var margin = dip2px(context, 5f).toFloat();
        left = l.toFloat()
        right = r.toFloat()
        top = t.toFloat()
        bottom = b.toFloat()
        //矩形 首先确定 上 下位置是不变的。动态改变的只是左右。 所以左右需要根据触摸的位置的改变
                left1 = left + margin
        right1 = left1 //默认跟最开始得一样。
        top1 = top + margin
        bottom1 = bottom - margin;
        arcMargin = dip2px(context, 10f).toFloat(); //圆弧
      //  出进度条的长度
        proRight = (right - margin) - (left + margin)
          pjNum = proRight / stopNum

    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var F1 = RectF(left, top, right, bottom)
        var F2 = RectF(left1, top1, right1, bottom1)
        canvas!!.drawRoundRect(F1, arcMargin, arcMargin, bgPaint)
        canvas!!.drawText(
            startNum.toString(),
            left + 50f,
            calculateFont(bgTextPaint, F1),
            bgTextPaint
        )
        canvas!!.drawText(
            stopNum.toString(),
            right - 100f,
            calculateFont(bgTextPaint, F1),
            bgTextPaint
        )

        //绘制第二个矩形 这里要动态的 根据
        canvas!!.drawRoundRect(F2, arcMargin, arcMargin, proPaint)
        //currentNum 如果当前
        //只有最左边的大于最低的时候才显示
        if ((right1 - left1) > pjNum) {
            canvas!!.drawText(
                currentNum.toString(),
                right1 - 50f,
                calculateFont(bgTextPaint, F1),
                proTextPaint
            )
        }


    }


    /**
     * 计算 文字基线。
     */
    fun calculateFont(print: Paint, rf: RectF): Float {
        val fontMetrics: Paint.FontMetrics = print.getFontMetrics()
        val top = fontMetrics.top //为基线到字体上边框的距离,即上图中的top
        val bottom = fontMetrics.bottom //为基线到字体下边框的距离,即上图中的bottom
        val baseLineY = (rf!!.centerY() - top / 2 - bottom / 2) //基线中间点的y轴计算公式

        return baseLineY
    }


    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {

    }


    //这个测的是绘制的部分， 这个准点（暂且这样理解）

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 获取宽-测量规则的模式和大小
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        // 获取高-测量规则的模式和大小
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        Log.e("onlayout:widthMode", "${widthMode}")
        Log.e("onlayout:widthSize", "${widthSize}")
        Log.e("onlayout:heightMode", "${heightMode}")
        Log.e("onlayout:heightSize", "${heightSize}")
        // 设置wrap_content的默认宽 / 高值
        // 默认宽/高的设定并无固定依据,根据需要灵活设置
        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看

        // 当布局参数设置为wrap_content时，设置默认值
        if (layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT && layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, heightSize)
            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
        } else if (layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, heightSize)
        } else if (layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, heightSize)
        }else{
            setMeasuredDimension(widthSize, heightSize)
        }
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
        //view 这个测量的指 整体的。
        Log.e("onlayout:left", "${l}")
        Log.e("onlayout:top", "${t}")
        Log.e("onlayout:right", "${r}")
        Log.e("onlayout:bottom", "${b}")

        jisuan(l, t-t, r, b-t-t)
    }

    //这个是在viewgraout
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)


//ViewGroup
//        var top = 0
//        val count: Int = getChildCount()
//        for (i in 0 until count) {
//            val child: View = getChildAt(i)
//            val lp = child.layoutParams as MarginLayoutParams
//            val childHeight = child.measuredHeight + lp.topMargin + lp.bottomMargin
//            val childWidth = child.measuredWidth + lp.leftMargin + lp.rightMargin
//            child.layout(0, top, childWidth, top + childHeight)
//            top += childHeight
//        }


    }

    //调用监听方法
    var onSildeInface: OnSildeInface? = null

    /**
     * 设置监听
     */
    fun setOnSildeInfac(onSildeInface: OnSildeInface) {
        this.onSildeInface = onSildeInface
    }


    //按下的时间
    var startTime: Long = 0
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            //按下
            MotionEvent.ACTION_DOWN -> {
                startTime = System.currentTimeMillis();
                var endTimeMove = System.currentTimeMillis();
//                if (endTimeMove - startTime > 100) {
                var bitmapPointX = event.x;
                Log.e("endTimeMove---1", "${endTimeMove}")

                Log.e("bitmapPointX", "${event.x}")
                //这里 判断不能越界了。越界分为2个方向，1-外层左边-边距的距离。2.右边的距离
                if (bitmapPointX < left + margin) {
                    right1 = left + margin

                } else if (bitmapPointX > right - margin) {
                    right1 = right - margin
                } else {
                    right1 = bitmapPointX
                    //这里要计算。的到当前是多少数字
                    currentNum = ((right1 - left + margin) / pjNum).toInt()
                    Log.e("bitmapPointX：currentNum", "${currentNum}")
                    onSildeInface?.onSlideValue(currentNum)
                    //传值
                    invalidate()//重新绘制，这里改编值
                }

            }
            //拖动
            MotionEvent.ACTION_MOVE -> {
                var endTimeMove = System.currentTimeMillis();
//                if (endTimeMove - startTime > 100) {
                var bitmapPointX = event.x;
                Log.e("bitmapPointX", "${event.x}")
                //这里 判断不能越界了。越界分为2个方向，1-外层左边-边距的距离。2.右边的距离
                if (bitmapPointX < left + margin) {
                    right1 = left + margin

                } else if (bitmapPointX > right - margin) {
                    right1 = right - margin
                } else {
                    right1 = bitmapPointX
                    //这里要计算。的到当前是多少数字
                    currentNum = ((right1 - left + margin) / pjNum).toInt()
                    onSildeInface?.onSlideValue(currentNum)

                    Log.e("bitmapPointX：currentNum", "${currentNum}")
                    invalidate()//重新绘制，这里改编值
                }


//                }
            }
            //抬起
            MotionEvent.ACTION_UP -> {
                //抬起的时间
                var endTime = System.currentTimeMillis()
                Log.e("endTimeMove---2", "${endTime}")

                if (endTime - startTime > 200) {//如果按下，抬起时间过大才认为是拖动，要执行动画。

                }
            }
        }


        return true

    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }


}


/**
 * 监听接口
 */
interface OnSildeInface {
    fun onSlideValue(pro: Int);
}

 