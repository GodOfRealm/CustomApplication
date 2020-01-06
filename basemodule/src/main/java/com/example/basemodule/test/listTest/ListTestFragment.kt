package com.example.basemodule.test.listTest

import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.basemodule.adapter.ViewHolder
import com.example.basemodule.base.list.BaseListFragment
import com.example.basemodule.net.common.ResponseObserver
import com.example.basemodule.net.common.RxUtil
import com.example.basemodule.test.ArticleWrapper
import com.example.basemodule.test.RetrofitHelper
import com.example.basemodule.widget.EmptyView

class ListTestFragment : BaseListFragment<ArticleWrapper.Article>() {
    override fun begin() {
        onRefresh()
    }

    override fun beginBeforeRequest(): Boolean {
        return false
    }
    override fun setupEmptyView(emptyView: EmptyView?) {
        emptyView?.setEmptyText("asdasdasds")
    }

    override fun generateAdapter(): BaseQuickAdapter<ArticleWrapper.Article, ViewHolder> {
        return TestListAdapter()
    }

    override fun fetchData(page: Int) {
        LogUtils.e("fuck--->" + page)
        RetrofitHelper.getApiService()
                .article
                .compose(RxUtil.rxSchedulerHelper(this, true))
                .subscribe(object : ResponseObserver<ArticleWrapper>() {
                    override fun onSuccess(response: ArticleWrapper) {
                        if (page < 2) {
                            var datalist = mutableListOf<ArticleWrapper.Article>()
                            for (index in 1..20) {
                                var item = ArticleWrapper.Article()
                                item.title = "fuck$page" + "--" + index
                                datalist.add(item)
                            }
                            response.datas = datalist
                        }
                        setData(response.datas, true, page)
                    }

                    override fun onFail(message: String?) {
                        super.onFail(message)
                        setData(null, false, page)
                    }
                })
    }
}