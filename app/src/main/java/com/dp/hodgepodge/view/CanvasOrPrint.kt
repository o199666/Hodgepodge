package com.dp.hodgepodge.view

import android.R.attr
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.dp.hodgepodge.R


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/20
 *  desc   : 熟悉 Canvas 和 Paint 的各个API
 *
 */

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CanvasOrPaint(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    /**
     * 画笔：主要功能如下
     * 1，颜色
     * 2，
     */
    var paint = Paint()
    var path = Path() // 初始化 Path 对象


    init {
        //设置抗锯齿开关
        paint.isAntiAlias = true
        //设置绘制模式 STROKE:不填充，FILL:填充 ，FILL_AND_STROKE
        paint.style = Paint.Style.STROKE
        //设置颜色
        paint.color = Color.RED
        //设置线条宽度
        paint.strokeWidth = 10f
//        可以设置点的形状，但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种，具体会在下一节里面讲。
        paint.strokeCap = Paint.Cap.BUTT

//
//        //爱心路径
//        // 使用 path 对图形进行描述（这段描述代码不必看懂）
//        path.addArc(200F, 200f, 400f, 400f, -225f, 225f);
//        path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false);
//        path.lineTo(400f, 542f);
    }


    /**
     * 坐标。绘制的View的
     */
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //=简单绘制=========================================================================================
        //圆形
//        canvas?.drawCircle(400f, 400f, 200f, paint)
        //矩形
//        canvas?.drawRect(150f, 150f, 300f, 300f, paint);
//        canvas?.drawRect(150f, 150f, 300f, 300f, paint);
        //爱心
//        canvas?.drawPath(path, paint);
        //圆角矩形
//        canvas?.drawRoundRect(100f,100f,300f,300f,50f,50f,paint)
//       路径方向有两种：顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise) 。 并且图形出现自相交时，用于判断填充范围的
//        addXX 添加子View
        /**
         * EVEN_ODD
        WINDING （默认值）
        INVERSE_EVEN_ODD：背景填充，交互的位置也填充
        INVERSE_WINDING:背景填充，交互的公共位置不填充
        WINDING 是「全填充」，而 EVEN_ODD 是「交叉填充」：
        这些都受CCW CW影响。不同的搭配效果不同
         */
//        paint.style = Paint.Style.FILL_AND_STROKE
//        path.fillType= Path.FillType.EVEN_ODD
//        paint.strokeWidth = 0f
//
//        path.addCircle(300F, 300F, 130F, Path.Direction.CW);
//        path.addCircle(450F, 300F, 130F, Path.Direction.CW);
//        canvas?.drawPath(path, paint)
//       弧形
        //圆角弧形
//        path.addRoundRect(RectF(100f,100f,200f,200f),110f,110f,Path.Direction.CW );
//        canvas?.drawPath(path,paint)
//        使用各种 Canvas.drawXXX() 方法 画直方图
//        paint.strokeWidth = 2f
//        path.addRect(60f, 200f, 120f, 600f, Path.Direction.CCW);
//        paint.color = Color.BLACK
//        path.addRect(140f, 280f, 200f, 600f, Path.Direction.CCW);
//        path.addRect(220f, 100f, 280f, 600f, Path.Direction.CCW);
//        path.addRect(300f, 490f, 360f, 600f, Path.Direction.CCW);
//        path.addRect(380f, 190f, 440f, 600f, Path.Direction.CCW);
//        path.addRect(460f, 490f, 520f, 600f, Path.Direction.CCW);
////        path.moveTo(0f, 0f); // 我移~~
////        path.lineTo(0f, 600f); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        canvas?.drawPath(path, paint)
//        canvas?.drawPath(path, paint)
//        canvas?.drawLine(0F, 600f, 600f, 600f, paint);
//        canvas?.drawLine(600f, 0f, 600f, 600f, paint);
// 绘制bitmap
//        var resources: Resources? = this.resources
//        val drawable: Drawable = resources!!.getDrawable(R.drawable.img1,null)
//        val bmp = BitmapFactory.decodeResource(resources, R.drawable.img2)
//        canvas?.drawBitmap(bmp,10f,10f,paint)
        //绘制文字
//        paint.strokeWidth = 2f
//        paint.textSize=80f
//        canvas?.drawText("这是绘制的文字？", 60f,60f, paint);

        //======paint的详细使用====================================================================================
        /**
         * LinearGradient----------线性渐变。
         * 参数：
        x0 y0 x1 y1：渐变的两个端点的位置
        color0 color1 是端点的颜色
        tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT。CLAMP （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式。具体的看一下例子就明白。
         */
//        val shader: Shader = LinearGradient(
//            100F, 100F, 500F, 500F, Color.parseColor("#E91E63"),
//            Color.parseColor("#2196F3"), Shader.TileMode.REPEAT
//        )
//        var paint1 = Paint()
//        paint1.shader = shader
//        canvas?.drawRect(10f, 100F, 800F, 500F, paint1);


        /**
         *  RadialGradient 辐射渐变
         *  参数：
        centerX centerY：辐射中心的坐标
        radius：辐射半径
        centerColor：辐射中心的颜色
        edgeColor：辐射边缘的颜色
        tileMode：辐射范围之外的着色模式。
         */
//        var paint = Paint()
//        val shader:Shader= RadialGradient(300F,300f,200f,Color.parseColor("#E91E63"),
//            Color.parseColor("#2196F3"), Shader.TileMode.REPEAT)
//        paint.shader = shader
//        canvas?.drawRect(100F,100F, 500f, 500f, paint)

        /**
         * SweepGradient 扫描渐变，
         * cx cy ：扫描的中心
        color0：扫描的起始颜色
        color1：扫描的终止颜色
         */
//        val shader1: Shader = SweepGradient(
//            300F, 300F, Color.parseColor("#E91E63"),
//            Color.parseColor("#2196F3")
//        );
//        var paint = Paint()
//        paint.shader = shader1
//        canvas?.drawCircle(300f, 300f, 200f, paint)


        /**
         * 圆形图片 图片着色器
         * bitmap：用来做模板的 Bitmap 对象
        tileX：横向的 TileMode
        tileY：纵向的 TileMode。
         */
//        var paint = Paint()
//
//        //加载图片
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        paint.shader = shade
//        paint.strokeWidth = 10f
//        //设置绘制模式 STROKE:不填充，FILL:填充 ，FILL_AND_STROKE
//        paint.style = Paint.Style.FILL_AND_STROKE
//        paint.color = Color.BLACK
//        canvas?.drawCircle(300F, 300F, 200F, paint)

        /**
         * ComposeShader 混合着色器
         * 所谓混合，就是把两个 Shader 一起使用。
         * 上面这段代码中我使用了两个 BitmapShader 来作为 ComposeShader() 的参数，而 ComposeShader() 在硬件加速下是不支持两个相同类型的 Shader 的，所以这里也需要关闭硬件加速才能看到效果。
        shaderA, shaderB：两个相继使用的 Shader
        mode: 两个 Shader 的叠加模式，即 shaderA 和 shaderB 应该怎样共同绘制。它的类型是 PorterDuff.Mode 。
         */

//        var paint = Paint()
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img1)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        var bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.img2)
//        val shade1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        // ComposeShader：结合两个 Shader
//        var shader3 =   ComposeShader(shade, shade1, PorterDuff.Mode.SRC_OVER);
//        paint.setShader(shader3)
//        canvas?.drawCircle(300F, 300F, 200F, paint)


        /**
         *  lightingColorFilter 用来模拟简单的光照效果的。
         */
//        var paint = Paint()
//        paint.style = Paint.Style.FILL_AND_STROKE
////        var lightingColorFilter: ColorFilter? = LightingColorFilter(0x00ffff, 0x000000)
//        var lightingColorFilter: ColorFilter? = LightingColorFilter(0xffffff, 0x003000)
//        paint.colorFilter = lightingColorFilter
//
//
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img1)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        paint.shader=shade
//        canvas?.drawCircle(300F, 300F, 200F, paint)


        /**
         *色彩优化
        Paint 的色彩优化有两个方法： setDither(boolean dither) 和 setFilterBitmap(boolean filter) 。它们的作用都是让画面颜色变得更加「顺眼」，但原理和使用场景是不同的。

        2.4.1 setDither(boolean dither)
        设置图像的抖动。
        setFilterBitmap(boolean filter)
        设置是否使用双线性过滤来绘制 Bitmap 。
        2.5 setPathEffect(PathEffect effect)
        使用 PathEffect 来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，也就是 drawLine() drawCircle() drawPath() 这些方法。大概像这样：

        CornerPathEffect
        把所有拐角变成圆角。
         */
//        var paint = Paint()
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img1)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        paint.shader = shade
//        //设置是否使用双线性过滤来绘制 Bitmap 。
//        paint.setFilterBitmap(true);
//        paint.setDither(true);
//
////setPathEffect(PathEffect effect)
//        val pathEffect: PathEffect = CornerPathEffect(20F)
//        paint.pathEffect = pathEffect
////CornerPathEffect
//
//        canvas?.drawRect(100f, 100F, 500F, 500F, paint)


        /**
         * 发光字体
         * setShadowLayer(float radius, float dx, float dy, int shadowColor)
        在之后的绘制内容下面加一层阴影。
         */
//        var paint = Paint()
//        paint.textSize=80F
//        paint.setShadowLayer(10F, 0f, 0f, Color.RED);
//        canvas?.drawText("发光很厉害吗！", 100F, 300F, paint);


        /**

         * 毛边图片
         * setShadowLayer(float radius, float dx, float dy, int shadowColor)
        在之后的绘制内容下面加一层阴影。
         */
//        var paint = Paint()
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//        paint.shader = shade
//        paint.setShadowLayer(10F, 0f, 0f, Color.RED);
//        canvas?.drawOval(100f, 100f, 200f, 200f, paint)

        /**
         * 模糊效果
         *
         *
         * setMaskFilter(MaskFilter maskfilter)
        为之后的绘制设置 MaskFilter。上一个方法 setShadowLayer() 是设置的在绘制层下方的附加效果；
        而这个 MaskFilter 和它相反，设置的是在绘制层上方的附加效果。




        radius 参数是模糊的范围， style 是模糊的类型。一共有四种：
        NORMAL: 内外都模糊绘制
        SOLID: 内部正常绘制，外部模糊
        INNER: 内部模糊，外部不绘制
        OUTER: 内部不绘制，外部模糊（什么鬼？）
         */

//        var paint = Paint()
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT)
//        paint.shader = shade
//        //模糊效果
//        paint.maskFilter = BlurMaskFilter(200F, BlurMaskFilter.Blur.NORMAL)
//        canvas?.drawOval(100f, 100f, 500f, 500f, paint)

        /**
         *
         *  EmbossMaskFilter
        浮雕效果的 MaskFilter。

        它的构造方法 EmbossMaskFilter(float[] direction, float ambient, float specular, float blurRadius) 的参数里，
        direction 是一个 3 个元素的数组，指定了光源的方向； ambient 是环境光的强度，数值范围是 0 到 1； specular 是炫光的系数； blurRadius 是应用光线的范围。
         */
//        var paint = Paint()
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//        val shade = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT)
//        paint.shader = shade
//        var arrfloat = arrayOf(1f, 2f, 3f)
//
//        //模糊效果
////        paint.maskFilter = EmbossMaskFilter(arrfloat, 0.2f, 8f, 10f)
//        canvas?.drawOval(100f, 100f, 500f, 500f, paint)

        /**
         * paint 初始化类
         *
         * rest（） set() 见文档
         */

        /**
         * Canvas 绘制文字的方式  ====================================================================
         */
//        var paint = Paint()
//        paint.setFakeBoldText(false);
//        //粗细
//        paint.strokeWidth = 10f
//        //设置文字大小。
//        paint.textSize = 30f
//        //设置字体，
//        //        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));
//        //设置颜色
//        paint.color = Color.BLACK
//        //设置字体粗细
//        paint.isFakeBoldText = true
//        //是否删除线
//        paint.setStrikeThruText(true);
//        //是否下划线
//        paint.setUnderlineText(true)
////设置文字横向错切角度。其实就是文字倾斜度的啦。
//        paint.setTextSkewX(-0.5f)
//        //s置文字横向放缩。也就是文字变胖变瘦。
//        paint.setTextScaleX(1f)
//        //设置字符间距。默认值是 0。
//        paint.setLetterSpacing(0.2f);
//        var text1: String? =
//            " text of the printing and typesetting industry."
//        canvas?.drawText("Lorem Ipsum is simply dummy", 100f, 200f, paint);

        /**
         * 图片范围裁剪=======================
         * 范围裁切有两个方法： clipRect() 和 clipPath()。裁切方法之后的绘制代码，都会被限制在裁切范围内。
         */

//        var paint = Paint()
//        paint.isAntiAlias = true
//        //设置绘制模式 STROKE:不填充，FILL:填充 ，FILL_AND_STROKE
//        paint.style = Paint.Style.STROKE
//        //设置颜色
//        paint.color = Color.RED
//        paint.strokeWidth = 10f
////        可以设置点的形状，但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种，具体会在下一节里面讲。
//        paint.strokeCap = Paint.Cap.BUTT
//        //得到
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//
//        canvas?.save()
//        //方形
//        canvas?.clipRect(220f, 150f, 500f, 400f)
//        canvas?.drawBitmap(bitmap, x, y, paint)
//        //最后重置避免下一次在此基础上又裁剪了一次
//        canvas?.restore()


//       clipPath() 其实和 clipRect() 用法完全一样，只是把参数换成了 Path ，所以能裁切的形状更多一些

        /**
         *  使用 Canvas 来做常见的二维变换：
         *  Canvas.translate(float dx, float dy) 平移
         */
//        var paint = Paint()
//        paint.isAntiAlias = true
//        //设置绘制模式 STROKE:不填充，FILL:填充 ，FILL_AND_STROKE
//        paint.style = Paint.Style.STROKE
//        //设置颜色
//        paint.color = Color.RED
//        paint.strokeWidth = 10f
////        可以设置点的形状，但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种，具体会在下一节里面讲。
//        paint.strokeCap = Paint.Cap.BUTT
//        //得到
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//
//        canvas?.save()
//        //平移 参数里的 dx 和 dy 表示横向和纵向的位移。
////        canvas?.translate(200f, 0f);
//        //旋转 参数里的 degrees 是旋转角度，单位是度（也就是一周有 360° 的那个单位），方向是顺时针为正向； px 和 py 是轴心的位置。
////        canvas?.rotate(45f, 40f, 40f);
//        //缩放 Canvas.scale(float sx, float sy, float px, float py) 放缩 参数里的 sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心。
////        canvas?.scale( 0.5f, 0.5f,x + bitmap.width / 2, y + bitmap.height / 2)
//       // 错切 skew(float sx, float sy) 错切
////        canvas?.skew( 0.5f, 0f)
//        canvas?.drawBitmap(bitmap, x, y, paint
//        )
//        //最后重置避免下一次在此基础上又裁剪了一次
//        canvas?.restore()


        /**
         * 2.2 使用 Matrix 来做变换
         * Matrix 做常见变换的方式：
        创建 Matrix 对象；
        调用 Matrix 的 pre/postTranslate/Rotate/Scale/Skew() 方法来设置几何变换；
        使用 Canvas.setMatrix(matrix) 或 Canvas.concat(matrix) 来把几何变换应用到 Canvas
         *
         *
         */

//        var paint = Paint()
//        val matrix = Matrix()
//        paint.isAntiAlias = true
//        //设置绘制模式 STROKE:不填充，FILL:填充 ，FILL_AND_STROKE
//        paint.style = Paint.Style.STROKE
//        //设置颜色
//        paint.color = Color.RED
//        paint.strokeWidth = 10f
////        可以设置点的形状，但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种，具体会在下一节里面讲。
//        paint.strokeCap = Paint.Cap.BUTT
//        //得到
//        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
//        matrix.reset()
////        //平移
////        matrix.postTranslate(200f, 0f)
////        //缩放
////        matrix.postScale(0.5f, 0.5f,x + bitmap.width / 2, y + bitmap.height / 2)
//
//        //自定义变换
//        val pointsSrc: Float = arrayOf<>(
//             left,
//            top,
//           right,
//             top,
//             left,
//             bottom,
//             right,
//             bottom
//        )
//        val pointsDst: Float = arrayOf<>(
//            left - 10f,
//            top + 50f,
//            right + 120f,
//            top - 90f,
//            left + 20f,
//            bottom + 30f,
//            right + 20f,
//            bottom + 60f
//        )
//        matrix.setPolyToPoly(pointsSrc, 0, pointsDst, 0, 4);
//        canvas?.save()
//        //把 Matrix 应用到 Canvas 有两个方法： Canvas.setMatrix(matrix) 和 Canvas.concat(matrix)
//        //不同的系统中 setMatrix(matrix) 的行为可能不一致，所以还是尽量用 concat(matrix) 吧）；
//        canvas?.concat(matrix)
//        canvas?.drawBitmap(bitmap, x, y, paint)
//        //最后重置避免下一次在此基础上又裁剪了一次
//        canvas?.restore()

        /**
         * 2.3 使用 Camera 来做三维变换---------------------------
         * 2.3.1 Camera.rotate*() 三维旋转
        Camera.rotate*() 一共有四个方法： rotateX(deg) rotateY(deg) rotateZ(deg) rotate(x, y, z)。这四个方法的区别不用我说了吧？
         */

        var paint = Paint()
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img3)
        var camera = Camera()
        canvas?.save();

        camera.save(); // 保存 Camera 的状态
        camera.rotateX(30f); // 旋转 Camera 的三维空间
        canvas?.translate(x, y); // 旋转之后把投影移动回来
        camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
        camera.restore(); // 恢复 Camera 的状态
        canvas?.drawBitmap(bitmap, x, y, paint);
        canvas?.restore();
    }


}
