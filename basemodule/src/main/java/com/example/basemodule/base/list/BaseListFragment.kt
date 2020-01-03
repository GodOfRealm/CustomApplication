package com.example.basemodule.base.list

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.basemodule.adapter.ViewHolder
import com.example.basemodule.base.BaseFragment

abstract class BaseListFragment<T> :BaseFragment() , IBaseListView<T>, IRefreshEvent<T>{
    private val refreshDelegate = RefreshEventDelegate(this)

    lateinit var mRecyclerView: RecyclerView

    lateinit var mAdapter: BaseQuickAdapter<T, ViewHolder>
    override fun getLayoutId(): Int {
    return    refreshDelegate.getLayoutID()
    }

    override fun init(savedInstanceState: Bundle?) {
        refreshDelegate.init(rootView)
        mRecyclerView = refreshDelegate.getRecyclerView()
        mAdapter = refreshDelegate.getAdapter()
        onRefresh()
    }
    override fun onRefreshComplete(data: MutableList<T>?, success: Boolean) {
        refreshDelegate.onRefreshComplete(data, success)
    }

    override fun onLoadMoreComplete(data: MutableList<T>?, success: Boolean) {
        refreshDelegate.onLoadMoreComplete(data, success)
    }

    override fun setRefreshEnable(enable: Boolean) {
        refreshDelegate.setRefreshEnable(enable)
    }

    override fun setLoadMoreEnable(enable: Boolean) {
        refreshDelegate.setLoadMoreEnable(enable)
    }


    override fun setShowErrorPage(showErrorPage: Boolean) {
        refreshDelegate.setShowErrorPage(showErrorPage)
    }


    override fun getCurPage(): Int {
        return refreshDelegate.getCurPage()
    }

    override fun onRefresh() {
        fetchData(PageIndicator.START)
    }

    override fun generateLayoutManager(): RecyclerView.LayoutManager? {
        return null
    }


    override fun setData(data: MutableList<T>?, success: Boolean, requestPage: Int) {
        if (requestPage == PageIndicator.START) {
            onRefreshComplete(data, success)
        } else {
            onLoadMoreComplete(data, success)
        }
    }

}