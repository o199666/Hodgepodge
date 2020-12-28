package com.cwj.news.activity

import android.os.Bundle
import com.cwj.common.base.BaseActivity
import com.cwj.common.base.BaseViewModel
import com.cwj.common.bean.news.NewsType
import com.cwj.news.R
import com.cwj.news.databinding.ActivityNewsBinding
import com.cwj.news.fragment.NewsFragment
import com.cwj.news.vm.NewsViewModel

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/9/29
 *  desc   : 新闻，文章，等等。
 */
class NewsActivity(override val viewModel: BaseViewModel=NewsViewModel()) :BaseActivity<ActivityNewsBinding,NewsViewModel>(){
    override val layoutId: Int
        get() = R.layout.activity_news

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transation = supportFragmentManager.beginTransaction()
        transation.add(R.id.newsfragment,NewsFragment())
        transation.commit()



        var news=NewsType("",1,"")


    }


}

 