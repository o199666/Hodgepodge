package com.cwj.main.fragment

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.main.R
import com.cwj.main.adapter.TestAdapter
import com.cwj.main.bean.TestBean
import com.cwj.main.databinding.MyFragmentBinding
import com.cwj.main.databinding.OneFragmentBinding
import com.cwj.main.databinding.TwoFragmentBinding
import com.cwj.main.vm.MainViewModel
import com.cwj.main.vm.TwoViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/17
 *  desc   :
 */
class TwoFragment(override val layoutId: Int= R.layout.two_fragment, override val viewModel: BaseViewModel= TwoViewModel()) :BaseFragment<TwoFragmentBinding,TwoViewModel>(){

    lateinit   var adapter:TestAdapter

    override fun lazyLoadData() {
        Log.e("lazyLoadDate:Two","111")

    }

    override fun initVD() {
         adapter=TestAdapter()
        bd.rv.layoutManager= LinearLayoutManager(context)
        adapter.animationEnable = false
        bd.rv.adapter=adapter
        var list = ArrayList<TestBean>()

        for (index in 1..100) {
            list.add(TestBean("$index-Title"))

        }

        adapter.addData(list)
        vm.queryNewType(true)
        vm.resultData.observe(this, Observer {

            Log.e("就结束","${list.size}")


            bd.dataTv.text=it.get(0).news_type_desc
        })


    }
    fun newInstance(): TwoFragment? {
        return TwoFragment()
    }
}

 