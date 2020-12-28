package com.dp.hodgepodge

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.dp.hodgepodge.databinding.ActivityTestBinding
import com.orhanobut.logger.Logger
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/9
 *  desc   :
 */
@Route(path = "/app/TestAc")
class TestAc(override val viewModel: BaseViewModel=LauncherViewModel()) : BaseActivity<ActivityTestBinding, LauncherViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bd.startCor.setOnClickListener {
            startCoroutine()
        }
        bd.dounCor.setOnClickListener {
            var img:Bitmap;
            CoroutineScope(Dispatchers.Main).launch {
                Logger.d("当前线程b-1：${Thread.currentThread().name}")
                withContext(Dispatchers.IO) {
                    Logger.d("当前线程b-2：${Thread.currentThread().name}")
                    img=getImage(path1)
                }
                bd.iv1.setImageBitmap(img)

                Logger.d("当前线程b-3：${Thread.currentThread().name}")

            }
        }
        bd.dounCor1.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                Logger.d("d-当前线程1：${Thread.currentThread().name}")
                bd.iv.setImageBitmap(getImage1(path2))
                Logger.d("d-当前线程3：${Thread.currentThread().name}")
            }
        }
        bd.dounCor2.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                var imag=getImage1(path2)
                var img1=Bitmap.createBitmap(imag,0,0,imag.width/2,imag.height/2)
                bd.iv.setImageBitmap(img1)
                var img2=Bitmap.createBitmap(imag,0,0,imag.width/3,imag.height/3)
                bd.iv6.setImageBitmap(img2)

        }
        }
        bd.dounCor5.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                //
                bd.progressBar.visibility= View.VISIBLE
                var imag=getImage1(path2)
                bd.iv6.setImageBitmap(imag)
                bd.progressBar.visibility= View.GONE

            }

        }
    }

    /**
     * 启动协程
     */
    fun startCoroutine() {
        CoroutineScope(Dispatchers.Main).launch {
            Logger.d("当前线程1：${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                Logger.d("当前线程2：${Thread.currentThread().name}")
            }
            Logger.d("当前线程3：${Thread.currentThread().name}")

        }
    }

    /**
     * 更新一张图片
     */

    var path1 = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1603094901&di=99535888c45335c85c7ef2ac7929248c&src=http://a0.att.hudong.com/56/12/01300000164151121576126282411.jpg"
    var path2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603104983776&di=cbce1c109382fa69bf0502aed4c41a88&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg"

    fun getImage(imagePath: String): Bitmap {
        var imageUrl = URL(imagePath)
        var conn = imageUrl.openConnection()
        conn.doInput = true
        conn.connect()
        var inputS = conn.getInputStream()
        var bitmap = BitmapFactory.decodeStream(inputS)
        inputS.close()

        return bitmap
    }

    /**
     * 获取图片       suspend 提醒 这个方法要做耗时操作
     */
    suspend fun getImage1(imagePath: String): Bitmap = withContext(Dispatchers.IO) {
        //显示
        delay(2000)
        var imageUrl = URL(imagePath)
        var conn = imageUrl.openConnection()
        conn.doInput = true
        conn.connect()
        var inputS = conn.getInputStream()
        var bitmap = BitmapFactory.decodeStream(inputS)
        inputS.close()
        Logger.d("d-当前线程2：${Thread.currentThread().name}")

        return@withContext bitmap
    }


}

 