package com.cwj.login.activity

import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.login.R
import com.cwj.login.databinding.ActivityLogin1Binding
import com.cwj.login.vm.LoginViewModel
import com.cwj.oftenview.view.OnSildeInface
import com.cwj.oftenview.view.SlideScoreView


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   :
 */
@Route(path = "/login/LoginActivity")
class LoginActivity : BaseActivity<ActivityLogin1Binding, LoginViewModel>() {
    override val layoutId: Int get() = R.layout.activity_login1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bd.rlv.setRightText("查看详细")
        bd.rlv.setText("看一看")
        bd.slideView.setOnSildeInfac(object :OnSildeInface{
            override fun onSlideValue(pro: Int) {
                Log.e("bitmapPointX：getProNum", "${pro}")

            }

        })

    }



    override val viewModel: BaseViewModel
        get() = LoginViewModel()

    override fun onRestart() {
        super.onRestart()

    }

}

 