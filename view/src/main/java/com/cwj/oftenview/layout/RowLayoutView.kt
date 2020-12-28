package com.cwj.oftenview.layout

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.cwj.oftenview.R


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/11/18
 *  desc   :通用的横向条目
 *
 */
class RowLayoutView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {
    private var rightDrawable = 0
    private var leftDrawable = 0
    private var text = "1"
    private var textColor = 0
    private var textSize = 16f
    private var rightText = ""
    private var rightTvColor = 0
    private var rightTvSize = 12f
    private var leftTextSpacing = 0f
    private var rightTextSpacing = 0f

    private lateinit var leftIv: AppCompatImageView
    private lateinit var leftTv: AppCompatTextView
    private lateinit var leftV: View
    private lateinit var rightV: View
    private lateinit var rightIv: AppCompatImageView
    private lateinit var rightTv: AppCompatTextView

    init {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        //初始化属性
        val typedArray: TypedArray =
            context.obtainStyledAttributes(attrs,
                R.styleable.RowLayoutView
            )
        rightDrawable =
            typedArray.getResourceId(R.styleable.RowLayoutView_rightDrawable, 0)
        leftDrawable =
            typedArray.getResourceId(R.styleable.RowLayoutView_leftDrawable, 0)
        text = typedArray.getString(R.styleable.RowLayoutView_text).orEmpty()
        textColor = typedArray.getColor(
            R.styleable.RowLayoutView_textColor,
            ContextCompat.getColor(context, R.color.colorFont)
        )
        textSize = typedArray.getDimension(R.styleable.RowLayoutView_textSize, 16f)
        leftTextSpacing = typedArray.getDimension(R.styleable.RowLayoutView_leftTextSpacing, 5f)
        rightTextSpacing = typedArray.getDimension(R.styleable.RowLayoutView_rightTextSpacing, 5f)
        rightText =
            typedArray.getString(R.styleable.RowLayoutView_rightText).orEmpty()
        rightTvColor = typedArray.getColor(
            R.styleable.RowLayoutView_rightTvColor,
            ContextCompat.getColor(context, R.color.colorFont)
        )
        rightTvSize = typedArray.getDimension(R.styleable.RowLayoutView_rightTvSize, 12f)
        val view = View.inflate(context,
            R.layout.row_layout_view, this)
        leftIv = view.findViewById(R.id.left_iv)
        leftTv = view.findViewById(R.id.left_tv)
        leftV = view.findViewById<View>(R.id.left_v)
        rightV = view.findViewById<View>(R.id.right_v)
        rightIv = view.findViewById(R.id.right_iv)
        rightTv = view.findViewById(R.id.right_tv)
        leftIv.setImageResource(leftDrawable)
        setText(text)
        leftTv.setTextColor(textColor)
        leftTv.paint.textSize = textSize
        rightIv.setImageResource(rightDrawable)
        rightTv.paint.textSize = rightTvSize
        rightTv.setTextColor(rightTvColor)
        setRightText(rightText)
        //设置宽度
        setWidth(leftV, leftTextSpacing.toInt())
        setWidth(rightV, rightTextSpacing.toInt())
        typedArray.recycle()

    }

    /**
     * 设置主标题内容
     */
    fun setText(text: String) {
        leftTv.text = text
    }

    /**
     * 设置右边文字的内容
     */
    fun setRightText(text: String) {
        rightTv.text = text
    }

    /**
     * 为指定View设置宽高。
     */
    private fun setWidth(view: View, width: Int) {
        //取控件当前的布局参数
        val params =
            view.layoutParams
        //设置宽度值
        params.width = width
        //设置高度值
//        params.height = dip2px(context, height)
//使设置好的布局参数应用到控件
        view.layoutParams = params
    }


}

 