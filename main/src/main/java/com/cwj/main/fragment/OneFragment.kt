package com.cwj.main.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.cwj.common.base.BaseFragment
import com.cwj.common.base.BaseViewModel
import com.cwj.main.R
import com.cwj.main.databinding.OneFragmentBinding
import com.cwj.main.vm.OneViewModel


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/17
 *  desc   :
 */
class OneFragment(override val layoutId: Int= R.layout.one_fragment, override val viewModel: BaseViewModel= OneViewModel()) :BaseFragment<OneFragmentBinding,OneViewModel>(){
    override fun lazyLoadData() {
        Log.e("lazyLoadDate:One","111")
    }

    override fun initVD() {
        var url=""
        bd.btn1.setOnClickListener {
            url="https://blog.csdn.net/wan903531306/article/details/107185681/"
            this!!.context?.let { it1 -> openBrowser(it1,url) }
        }
        //A陈文杰:
        //http://m.z0g8orz.cn/?id=75980875
        bd.btn2.setOnClickListener {
            url="http://m.z0g8orz.cn/?id=75980875"
            this!!.context?.let { it1 -> openBrowser(it1,url) }

        }
    bd.btn3.setOnClickListener {
            url="http://kwq.doy5.cn/relation_view.php?parent=425052"
            this!!.context?.let { it1 -> openBrowser(it1,url) }
        }
        bd.btn4.setOnClickListener {
            url="http://mango.wfc4eb.cn/tdnja/ednzu/5840643ednzu2064006tdnja3784561/wntduuhfezgoqrvxmxiqqoplwejxuwl.htm?aopwpi=7445667825&sbplseoh=wlenpovnze&sxhjwvaoui=665538&dxrjvodzr=frmofhrqwe"
            this!!.context?.let { it1 -> openBrowser(it1,url) }
        }


        vm.queryNewType(true)

        vm.resultData.observe(this, Observer {
            bd!!.dataTv.text=it.get(2).news_type_name

        })
    }
    fun openBrowser(context: Context, url: String?) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse(url)
        // 注意此处的判断intent.resolveActivity()可以返回显示该Intent的Activity对应的组件名
        // 官方解释 : Name of the component implementing an activity that can display the intent
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            val componentName = intent.resolveActivity(context.getPackageManager())
            // 打印Log   ComponentName到底是什么
            Log.d("componentName", "componentName = " + componentName.className)
            context.startActivity(
                Intent.createChooser(
                    intent,
                    "请选择浏览器"
                )
            )
        } else {
            Toast.makeText(
                context.getApplicationContext(),
               "失败！",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun newInstance(): OneFragment? {
        return OneFragment()
    }


}

 