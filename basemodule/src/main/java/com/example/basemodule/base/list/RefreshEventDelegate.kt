package com.example.basemodule.base.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.basemodule.R
import com.example.basemodule.adapter.ViewHolder
import com.example.basemodule.base.list.view.CustomClassicsFooter
import com.example.basemodule.base.list.view.CustomClassicsHeader
import com.example.basemodule.utils.CollectionUtil
import com.example.basemodule.widget.EmptyView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshHeader

/**
 * ListActivity和ListFragment的列表相关操作的代理类
 */

class RefreshEventDelegate<T>(refresh: IRefreshEvent<T>) {
    var mPageIndicator = PageIndicator()
    private var mShowError = true
    lateinit var mRootView: View
    lateinit var refreshLayout: SmartRefreshLayout
    lateinit var mAdapter: BaseQuickAdapter<T, ViewHolder>
    lateinit var mRecyclerView: RecyclerView
    var mMaster: IRefreshEvent<T> = refresh

    private var mEmptyView: EmptyView? = null
    private var mNetworkView: EmptyView? = null

    fun getLayoutID(): Int {
        return R.layout.base_layout_list
    }

    fun init(rootView: View) {
        mRootView = rootView
        refreshLayout = mRootView.findViewById(R.id.base_srl_list_refreshLayout)
        refreshLayout.setOnRefreshListener {
            mMaster.onRefresh()
        }
        refreshLayout.setOnLoadMoreListener {
            mMaster.fetchData(mPageIndicator.curPage + 1)
        }

        if (refreshLayout.getParent() is LinearLayout) {
            (refreshLayout.getLayoutParams() as LinearLayout.LayoutParams).weight = 1f
        }

        mRecyclerView = rootView.findViewById(R.id.base_rcv_list_content)

        val layoutManager = mMaster.generateLayoutManager()
        if (layoutManager != null) {
            mRecyclerView.layoutManager = layoutManager
        }
        mAdapter = mMaster.generateAdapter()
        mRecyclerView.adapter = mAdapter
        mAdapter.setHeaderAndEmpty(true)
        refreshLayout.setRefreshHeader(CustomClassicsHeader(mRootView.context))
        refreshLayout.setRefreshFooter(CustomClassicsFooter(mRootView.context))
        setEmptyView()
    }

    //设置下拉刷新样式
    fun setRefreHead(header: RefreshHeader) {
        refreshLayout.setRefreshHeader(header)
    }

    fun onRefreshComplete(data: List<T>?, success: Boolean) {
        if (success) {
            refreshLayout.setEnableLoadMore(true)
            mPageIndicator.firstPage()
            if (CollectionUtil.isEmpty(data)) {
                setEmptyView()
                refreshLayout.setEnableLoadMore(false)
            }
            mAdapter.setNewData(data)
        } else if (mShowError) {
            setNotNetworkView()
        }
        refreshLayout.finishRefresh(success)
    }

    fun onLoadMoreComplete(data: List<T>?, success: Boolean) {
        if (success) {
            if (CollectionUtil.isEmpty(data)) {
                refreshLayout.finishLoadMoreWithNoMoreData()
            } else {

                mPageIndicator.nextPage()
                mAdapter.addData(data!!)
                refreshLayout.finishLoadMore()
            }
        } else {
            mAdapter.loadMoreFail()
        }
    }

    /**
     * Desc: 设置空页面
     *
     *
     */
    private fun setEmptyView() {
        if (mEmptyView == null) {
            mEmptyView = EmptyView(mRootView.getContext())
            // 默认实现重试刷新操作，需要更改在setupEmptyView方法中重新设置即可
            mEmptyView!!.retryCallback = {
                mMaster.onRefresh()
            }
            mMaster.setupEmptyView(mEmptyView)
        }
        mAdapter.setEmptyView(mEmptyView)
    }

    /**
     * Desc: 无网络显示页面
     *
     *
     */
    private fun setNotNetworkView() {
        if (mNetworkView == null) {
            mNetworkView = EmptyView(mRootView.getContext())

            mNetworkView!!.setEmptyImageResource(R.mipmap.list_empty_ic_fans)
            mNetworkView!!.setEmptyText("网络开小差了~请刷新重试")
            mNetworkView!!.setRetryText("刷新")
            mEmptyView!!.retryCallback = {
                mMaster.onRefresh()
            }
        }
        mAdapter.setEmptyView(mNetworkView)
    }

    fun getRecyclerView(): RecyclerView {
        return mRecyclerView
    }

    fun getAdapter(): BaseQuickAdapter<T, ViewHolder> {
        return mAdapter
    }

    /**
     * Desc:是否允许下拉刷新

     * @param enable enable
     */
    fun setRefreshEnable(enable: Boolean) {
        refreshLayout.setEnableRefresh(enable)
    }

    /**
     * Desc: 是否允许加载更多

     * @param enable enable
     */
    fun setLoadMoreEnable(enable: Boolean) {
        refreshLayout.setEnableLoadMore(enable)
    }


    /**
     * Desc: 是否显示无网络的错误页面

     * @param showError
     */
    fun setShowErrorPage(showError: Boolean) {
        this.mShowError = showError
        if (mNetworkView != null) {
            mNetworkView!!.setVisibility(View.GONE)
        }
    }
    /**
     * Desc: 获取页面的跟布局
     *

     * @return view group
     */
    fun getPageRootView(): ViewGroup {
        return mRecyclerView.parent.parent as ViewGroup
    }

    /**
     * Desc: 获取当前页码

     */
    fun getCurPage(): Int {
        return mPageIndicator.curPage
    }
}