package com.dp.hodgepodge

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.TypeEvaluator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import androidx.annotation.RequiresApi
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.dp.hodgepodge.databinding.ActivityZiviewBinding


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/20
 *  desc   : 展示自定义view
 */
@Route(path = "/app/ZiViewActivity")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ZiViewActivity(override val viewModel: BaseViewModel) : BaseActivity<ActivityZiviewBinding, BaseViewModel>() {
    @SuppressLint("ObjectAnimatorBinding")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 创建 ObjectAnimator 对象

        // 创建 ObjectAnimator 对象
//        val animator: ObjectAnimator = ObjectAnimator.ofFloat(bd.animate, "progress", 0f, 65f)
// 执行动画
// 执行动画
        bd.animate.setOnClickListener {
            anim2color()

        }
        bd.ll.setOnClickListener{
            anim4()

        }
        // imageView1: 500 毫秒


    }

    /**
     * 方式1
     */
    fun anim1() {
        bd.animate.animate()
            .translationX(500f)
            .setDuration(500)
                //插值器
            .setInterpolator(  LinearInterpolator())
            .start()
    }

    /**
     * PropertyValuesHolder 的意思从名字可以看出来，它是一个属性值的批量存放地。
     * 所以你如果有多个属性需要修改，可以把它们放在不同的 PropertyValuesHolder 中，
     * 然后使用 ofPropertyValuesHolder() 统一放进 Animator。这样你就不用为每个属性单独创建一个 Animator 分别执行了。
     * 多个动画同时进行
     */
    fun anim4(){
//        bd.animate.animate()
//            .scaleX(1f)
//            .scaleY(1f)
//            .alpha(1f)
//            .start()

//
    var holder1 = PropertyValuesHolder.ofFloat("scaleX", 5f);
    var holder2 = PropertyValuesHolder.ofFloat("scaleY", 5f);
    var holder3 = PropertyValuesHolder.ofFloat("alpha", 5f);

    var animator = ObjectAnimator.ofPropertyValuesHolder(bd.animate, holder1, holder2, holder3)
    animator.start();
}

    /**
     *有的时候，你不止需要在一个动画中改变多个属性，还会需要多个动画配合工作，比如，在内容的大小从 0 放大到 100% 大小后开始移动。这种情况使用 PropertyValuesHolder 是不行的，因为这些属性如果放在同一个动画中，需要共享动画的开始时间、结束时间、Interpolator 等等一系列的设定，这样就不能有先后次序地执行动画了。

    这就需要用到 AnimatorSet 了
     *
     */
    fun anm5(){

    }



    /**
     * 插值器
     *Interpolator》 先加速再减速。这是默认的 Interpolator，也就是说如果你不设置的话，那么动画将会使用这个 Interpolator。
     * 用途：就像上面说的，它是一种最符合物理世界的模型，所以如果你要做的是最简单的状态变化（位移、放缩、旋转等等），那么一般不用设置 Interpolator，就用这个默认的最好。
     *
     * LinearInterpolator> 匀速。
     * AccelerateInterpolator 持续加速。在整个动画过程中，一直在加速，直到动画结束的一瞬间，直接停止。
     *
     * DecelerateInterpolator 持续减速直到 0。
     * AnticipateInterpolator  先回拉一下再进行正常动画轨迹。效果看起来有点像投掷物体或跳跃等动作前的蓄力
     *如果是图中这样的平移动画，那么就是位置上的回拉；如果是放大动画，那么就是先缩小一下再放大；其他类型的动画同理。
     *
     *OvershootInterpolator 动画会超过目标值一些，然后再弹回来。效果看起来有点像你一屁股坐在沙发上后又被弹起来一点的感觉。
     *
     * AnticipateOvershootInterpolator  上面这两个的结合版：开始前回拉，最后超过一些然后回弹。
     *
     * BounceInterpolator 在目标值处弹跳。有点像玻璃球掉在地板上的效果。
     * CycleInterpolator 这个也是一个正弦 / 余弦曲线，不过它和 AccelerateDecelerateInterpolator 的区别是，
     * 它可以自定义曲线的周期，所以动画可以不到终点就结束，也可以到达终点后回弹，回弹的次数由曲线的周期决定，
     * 曲线的周期由 CycleInterpolator() 构造方法的参数决定。参数为 0.5f：
     *
     * PathInterpolator 自定义动画完成度 / 时间完成度曲线。
     */

    /**
     * 方式2
     */
    fun anim2() {
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(
            bd.animate, "translationY", 800f
        )
        animator.duration = 2000
        animator.interpolator= OvershootInterpolator()
        animator.start()
    }


    @SuppressLint("ObjectAnimatorBinding")
    fun anim2color(){
        var animator = ObjectAnimator.ofArgb(bd.ll, "color", 0xffff0000.toInt(), 0xff00ff00.toInt())
        animator.setEvaluator(HsvEvaluator())
        animator.start()
    }
    override val layoutId: Int
        get() = R.layout.activity_ziview



}

public class HsvEvaluator : TypeEvaluator<Int> {
    var startHsv = FloatArray(3)
    var endHsv = FloatArray(3)
    var outHsv = FloatArray(3)
    override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        // 把 ARGB 转换成 HSV
        Color.colorToHSV(startValue, startHsv)
        Color.colorToHSV(endValue, endHsv)

        // 计算当前动画完成度（fraction）所对应的颜色值
        if (endHsv[0] - startHsv[0] > 180) {
            endHsv[0] -= 360
        } else if (endHsv[0] - startHsv[0] < -180) {
            endHsv[0] += 360
        }
        outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction
        if (outHsv[0] > 360) {
            outHsv[0] -= 360
        } else if (outHsv[0] < 0) {
            outHsv[0] += 360
        }
        outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction
        outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction

        // 计算当前动画完成度（fraction）所对应的透明度
        val alpha =
            startValue shr 24 + ((endValue shr 24 - startValue shr 24) * fraction).toInt()

        // 把 HSV 转换回 ARGB 返回
        return Color.HSVToColor(alpha, outHsv)
    }
}

private operator fun Any.set(i: Int, value: Int) {

}


