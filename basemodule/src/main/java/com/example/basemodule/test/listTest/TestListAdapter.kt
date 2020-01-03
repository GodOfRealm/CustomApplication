package com.example.basemodule.test.listTest

import com.example.basemodule.adapter.BaseAdapter
import com.example.basemodule.adapter.ViewHolder
import com.example.basemodule.test.ArticleWrapper
import com.example.testmodule.R

class TestListAdapter:BaseAdapter<ArticleWrapper.Article> (R.layout.test_item){
    override fun convert(helper: ViewHolder, item: ArticleWrapper.Article) {
        helper.setText(R.id.test_tv_list_title,item.title)
    }
}