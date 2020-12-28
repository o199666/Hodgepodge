package com.cwj.main.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.main.R
import com.cwj.main.ViewPagerAdapter
import com.cwj.main.databinding.Main2Binding
import com.cwj.main.databinding.MainActivityBinding
import com.cwj.main.fragment.HomeFragment
import com.cwj.main.fragment.MyFragment
import com.cwj.main.fragment.OneFragment
import com.cwj.main.fragment.TwoFragment
import com.cwj.main.vm.MainViewModel
import com.cwj.oftenview.view.DotView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   :项目主页入口
 */

@Route(path = "/main/MainActivity2")
class Main2Activity(
    override val layoutId: Int = R.layout.main2,
    override val viewModel: BaseViewModel = MainViewModel()
) : BaseActivity<Main2Binding, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView1()
    }

    //初始化
    @SuppressLint("RestrictedApi")
    private fun initView1() {
        val fragments = getFragments()
        bd.vp2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
        //进制viewpage滑动
        bd.vp2.isUserInputEnabled = false
        //设置缓存数量，默认3个。
        bd.vp2.offscreenPageLimit=6

        bd.navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_fragment -> {
                    bd.vp2.setCurrentItem(0, false)
                }
                R.id.one_fragment -> {
                    bd.vp2.setCurrentItem(1, false)
                }
                R.id.two_fragment -> {
                    bd.vp2.setCurrentItem(2, false)
                }
                R.id.my_fragment -> {
                    bd.vp2.setCurrentItem(3, false)
                }
            }
            true
        }

        var dot = DotView(this, 12, isOverstep = 2, marTop = 5, marRight = 10)
        dot.setTargetView(getBadegeView(0))

        var dot1 = DotView(this, 123, isOverstep = 2, marTop = 5, marRight = 10)
        dot1.setTargetView(getBadegeView(1))

        var dot2 = DotView(this, isOverstep = 2, marTop = 10, marRight = 30)
        dot2.setTargetView(getBadegeView(2))

    }

    /**
     * BottomNavigationMenuView view 获取图标
     */
    private fun getBadegeView(viewIndex: Int): View {
        // 具体child的查找和view的嵌套结构请在源码中查看
        // 从bottomNavigationView中获得BottomNavigationMenuView
        val menuView: BottomNavigationMenuView =
            bd.navView.getChildAt(0) as BottomNavigationMenuView
        // 从BottomNavigationMenuView中获得childview, BottomNavigationItemView
        if (viewIndex < menuView.getChildCount()) {
            // 获得viewIndex对应子tab
            val view: View = menuView.getChildAt(viewIndex)
            // 从子tab中获得其中显示图片的ImageView
            val icon: View = view.findViewById(R.id.icon)
//
//            // 获得图标的宽度
//            val iconWidth: Int = icon.width
//            // 获得tab的宽度/2
//            val tabWidth: Int = view.width / 2
//            // 计算badge要距离右边的距离
//            val spaceWidth = tabWidth - iconWidth
            // 显示badegeview

            // 显示badegeview
            return icon
        }
        return null!!
    }

    /**
     * 动态设置Nav的item
     */


    fun getFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>(4)
        val home = HomeFragment()
        var bundle = Bundle()
        bundle.putString("title", "1")
        home.arguments = bundle

        val one = OneFragment()
        bundle = Bundle()
        bundle.putString("title", "2")
        one.arguments = bundle

        val two = TwoFragment()
        bundle = Bundle()
        bundle.putString("title", "3")
        two.arguments = bundle

        val my = MyFragment()
        bundle = Bundle()
        bundle.putString("title", "4")
        my.arguments = bundle
        fragments.add(home)
        fragments.add(one)
        fragments.add(two)
        fragments.add(my)
        return fragments
    }

}

 