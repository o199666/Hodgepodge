package com.cwj.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cwj.main.fragment.HomeFragment
import com.cwj.main.fragment.MyFragment
import com.cwj.main.fragment.OneFragment
import com.cwj.main.fragment.TwoFragment

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/21
 *  desc   :
 */
class ViewPagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
 var fragment = when (position) {
            0 -> HomeFragment()
            1 -> OneFragment()
            2 -> TwoFragment()
            3 -> MyFragment()
            else -> Fragment()
        }

        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt("bade", position + 1)
        }
        return fragment
    }
}

 