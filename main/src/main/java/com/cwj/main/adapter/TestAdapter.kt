package com.cwj.main.adapter


import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cwj.main.R
import com.cwj.main.bean.TestBean


/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/12/24
 *  desc   :
 */
class TestAdapter:  BaseQuickAdapter<TestBean,BaseViewHolder>(R.layout.revy_test_item){
    override fun convert(holder: BaseViewHolder, item: TestBean) {
        holder.setText(R.id.item_tv,item.title)
    }

}

 