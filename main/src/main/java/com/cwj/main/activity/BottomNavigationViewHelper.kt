package com.cwj.main.activity

import android.annotation.SuppressLint
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.reflect.Field

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/18
 *  desc   :
 */
class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    fun disableShiftMode(view: BottomNavigationView) {
        val menuView: BottomNavigationMenuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode: Field = menuView.javaClass.getDeclaredField("labelVisibilityMode")
            shiftingMode.setAccessible(true)
            shiftingMode.setInt(menuView, 1) //labelVisibilityMode
            //            shiftingMode.setBoolean(menuView, false);//mShiftingMode
            shiftingMode.setAccessible(false)
            for (i in 0 until menuView.getChildCount()) {
                val item: BottomNavigationItemView =
                    menuView.getChildAt(i) as BottomNavigationItemView

//                item.setShiftingMode(false);
                item.setShifting(false)
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked())
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }
    }
}

 