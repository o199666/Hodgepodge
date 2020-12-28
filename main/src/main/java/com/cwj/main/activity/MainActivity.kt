package com.cwj.main.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.QuickContactBadge
import androidx.core.view.setPadding
import androidx.lifecycle.ViewModelStore
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.main.R
import com.cwj.main.databinding.MainActivityBinding
import com.cwj.main.vm.MainViewModel
import com.cwj.oftenview.view.DotView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import q.rorbin.badgeview.QBadgeView


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   :项目主页入口
 */

@Route(path = "/main/MainActivity")
class MainActivity(
    override val layoutId: Int = R.layout.main_activity,
    override val viewModel: BaseViewModel = MainViewModel()
) : BaseActivity<MainActivityBinding, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView1()
    }

    //初始化
    @SuppressLint("RestrictedApi")
    private fun initView1() {
        val navController = findNavController(R.id.nav_host_fragment)
        bd.navView.setupWithNavController(navController)

        var dot = DotView(this, 12,isOverstep = 2,marTop = 5,marRight = 10)
        dot.setTargetView(getBadegeView(0))

        var dot1 = DotView(this, 123,isOverstep = 2,marTop = 5,marRight = 10)
        dot1.setTargetView(getBadegeView(1))

        var dot2 = DotView(this,isOverstep = 2,marTop = 10,marRight = 30)
        dot2.setTargetView(getBadegeView(2))

    }

    /**
     * BottomNavigationMenuView view 获取图标
     */
    private fun getBadegeView(viewIndex: Int):View {
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
    fun setNavItem() {
        ///1 不开动画 0 动画
//        bd.navView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
//        bd.navView.menu.add(0, 0, 0, "首页").setShowAsAction(SHOW_AS_ACTION_IF_ROOM)

        var dotView = DotView(this)
//        bd.navView.menu.add(0, 1, 1, "音乐").setShowAsAction(SHOW_AS_ACTION_IF_ROOM)
//        bd.navView.menu.getItem(1).setIcon(R.drawable.ic_movie_24)
//        bd.navView.menu.add(0, 2, 2, "发现").setShowAsAction(SHOW_AS_ACTION_IF_ROOM)
//        bd.navView.menu.getItem(2).setIcon(R.drawable.ic_music_24);
//        bd.navView.menu.add(0, 3, 3, "我的").setShowAsAction(SHOW_AS_ACTION_IF_ROOM)
//        bd.navView.menu.getItem(3).setIcon(R.drawable.ic_my_24)
    }


}

 