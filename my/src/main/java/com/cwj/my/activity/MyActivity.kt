package com.cwj.my.activity
import android.os.Bundle
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.my.R
import com.cwj.my.databinding.ActivityMy1Binding
import com.cwj.my.fragment.MyFragment
import com.cwj.my.vm.MyViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   : 我的
 */
class MyActivity(override val viewModel: BaseViewModel=MyViewModel()) : BaseActivity<ActivityMy1Binding, MyViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_my1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transation = supportFragmentManager.beginTransaction()
        transation.add(R.id.fragmentlayout,MyFragment())
        transation.commit()
    }


}

 