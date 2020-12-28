package com.cwj.main.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.main.R
import com.cwj.main.databinding.Main1ActivityBinding
import com.cwj.main.fragment.HomeFragment
import com.cwj.main.fragment.MyFragment
import com.cwj.main.fragment.OneFragment
import com.cwj.main.fragment.TwoFragment
import com.cwj.main.vm.MainViewModel


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   :项目主页入口
 */

@Route(path = "/main/MainActivity1")
class Main1Activity(
    override val layoutId: Int = R.layout.main1_activity,
    override val viewModel: BaseViewModel = MainViewModel()
) : BaseActivity<Main1ActivityBinding, MainViewModel>() {

//    var homeFragment = yiHomeFragment()
    var oneFragment = OneFragment()
    var twoFragment = TwoFragment()
    var myFragment = MyFragment()
    lateinit var isFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView1()
    }


    //初始化
    private fun initView1() {


//        val fragmentManager: FragmentManager = supportFragmentManager
//        fragmentManager.beginTransaction().add(R.id.fl_fragment, homeFragment).commit()
//        isFragment = homeFragment
//        bd.navView.setOnNavigationItemReselectedListener {
//            changePageFragment(it.itemId)
//        }
    }

    /**
     *  选中就切换，
     */
    fun changePageFragment(id: Int) {
        when (id) {
            R.id.home_fragment -> {
//                switchFragment(homeFragment)
            }
            R.id.one_fragment -> {
                switchFragment(oneFragment)
            }
            R.id.two_fragment -> {
                switchFragment(twoFragment)

            }
            R.id.my_fragment -> {
                switchFragment(myFragment)
            }
        }
    }

//    /**
//     * 切换Fragmnent
//     */
//    fun switchFragment(
//        from: Fragment?,
//        to: Fragment?
//    ) {
//        if (to == null) return
//        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
//        if (!to.isAdded) {
//            if (from == null) {
//                transaction.add(R.id.fl_fragment, to).show(to).commit()
//            } else {
//                // 隐藏当前的fragment，add下一个fragment到Activity中
//                transaction.hide(from).add(R.id.fl_fragment, to).commitAllowingStateLoss()
//            }
//        } else {
//            // 隐藏当前的fragment，显示下一个
//            transaction.hide(from!!).show(to).commit()
//        }
//        fragment = to
//    }

    private fun switchFragment(fragment: Fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if (isFragment !== fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                supportFragmentManager.beginTransaction().hide(isFragment)
                    .add(R.id.fl_fragment, fragment).commit()
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                supportFragmentManager.beginTransaction().hide(isFragment).show(fragment)
                    .commit()
            }
            isFragment = fragment
        }
    }
}

 