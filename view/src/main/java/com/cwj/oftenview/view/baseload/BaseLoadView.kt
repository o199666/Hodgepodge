package com.cwj.oftenview.view.baseload

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.cwj.oftenview.R

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/28
 *  desc   : 网络加载loading
 */
class BaseLoadView : LinearLayout {


    fun init(application: Application) {

    }


    fun setNetWorkImage(networkImage: Int) {
        this.networkImage = networkImage
    }

    fun setErrorImage(errorImage: Int) {
        this.errorImage = errorImage
    }

    fun setNotLoginImage(notLoginImage: Int = R.drawable.ic_load_not_login) {
        this.notLoginImage = notLoginImage
    }

    fun setEmptyImage(emptyImage: Int = R.drawable.ic_load_empty) {
        this.emptyImage = emptyImage
    }

    init {

        initView()
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

    //无网络
    private var networkImage: Int = R.drawable.ic_load_not_network
    //加载中
    private var lodingImage: Int = R.drawable.ic_load_loading

    //未登录
    private var notLoginImage: Int = R.drawable.ic_load_not_login

    //请求错误
    private var errorImage: Int = R.drawable.ic_load_fail

    //空数据
    private var emptyImage: Int = R.drawable.ic_load_empty

    lateinit var state_iv: ImageView
    lateinit var click_btn: Button
    lateinit var msg_tv: TextView
    lateinit var btnClick: onBtnClick


    fun initView() {
        val view = View.inflate(
            context, R.layout.baseload_view, this
        )
        state_iv = view.findViewById(R.id.state_iv)
        click_btn = view.findViewById(R.id.click_btn)
        msg_tv = view.findViewById(R.id.msg_tv)
        //设置全屏
        val linearParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )

        view!!.layoutParams = linearParams
    }

    /**
     * 设置不同的加载状态。
     */
    fun setStete(loadState: LoadState) {

        when (loadState) {
            LoadState.LOADING -> {
                state_iv.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        lodingImage
                    )
                )
                setRotation(state_iv)
                click_btn.visibility = View.GONE
                msg_tv.text = "加载中"
            }

            LoadState.EMPTY -> {
                state_iv.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        emptyImage
                    )
                )
                click_btn.visibility = View.GONE
                msg_tv.text = "暂无数据"
            }
            LoadState.NET_WORK -> {
                state_iv.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        networkImage
                    )
                )

                click_btn.visibility = View.VISIBLE
                msg_tv.text = "网络不给力，点击重试"
                click_btn.text = "重试"

                click_btn.setOnClickListener {
                    btnClick.onClick(it, LoadState.NET_WORK)
                }
            }

            LoadState.NOLOGIN -> {
                state_iv.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        notLoginImage
                    )
                )

                click_btn.visibility = View.VISIBLE
                msg_tv.text = "登录即可查看"
                click_btn.text = "登录"
                click_btn.setOnClickListener {
                    btnClick.onClick(it, LoadState.NET_WORK)

                }
            }


            LoadState.ERROR -> {
                state_iv.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        errorImage
                    )
                )

                click_btn.visibility = View.VISIBLE
                msg_tv.text = "请求错误："
                click_btn.text = "重试"
                click_btn.setOnClickListener {
                    btnClick.onClick(it, LoadState.NET_WORK)

                }
            }


        }
    }

    /**
     * 关闭对话框
     */
    fun dismiss(view: View) {
        // 这里加个渐变，短暂的动画 消失。
        view.visibility = View.GONE
    }

    var duration = 1000L
    fun setRotation(view: View?) {
        val objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0f, 359f)
        objectAnimator.repeatCount = ValueAnimator.INFINITE
        objectAnimator.duration = duration
        objectAnimator.interpolator = LinearInterpolator()
        objectAnimator.start()
    }

    /**
     * 外部传入的事件
     */
    fun setOnBtnClick(onBtnClick: onBtnClick) {
        this.btnClick = onBtnClick
    }
}



 