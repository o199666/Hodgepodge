package com.dp.hodgepodge

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.common.config.APath
import com.dp.hodgepodge.databinding.ActivityLuancherBinding

/**
 * 启动页面。
 */
@Route(path = APath.APP.LUNCHER)
class LuancherActivity(override val layoutId: Int=R.layout.activity_luancher, override val viewModel: BaseViewModel=LauncherViewModel()) : BaseActivity<ActivityLuancherBinding, LauncherViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.queryNewType(true)
        vm.resultData.observe(this, Observer {
            bd.tv.text = it[0].news_type_name
        })
        bd.startLogin.setOnClickListener {
            startARouter(APath.LOGIN.LOGIN)
        }

        bd.ziview.setOnClickListener {
            startARouter(APath.APP.ZIVIEW)
        }

        bd.startTest.setOnClickListener {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
            startARouter(APath.APP.TEST)
        }
        bd.startLuancher.setOnClickListener {
            startARouter(APath.MAIN.MAIN)
        }
        bd.startLuancher1.setOnClickListener {
            startARouter(APath.MAIN.MAIN1)
        }
        bd.startLuancher2.setOnClickListener {
            startARouter(APath.MAIN.MAIN2)
        }
    }




//    override fun regVideModel() {

//    }
}