package com.example.basemodule.base.list;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.basemodule.adapter.ViewHolder;
import com.example.basemodule.widget.EmptyView;


public interface IRefreshEvent<T> {

    /**
     * Desc: 刷新列表

     */
    void onRefresh();

    /**
     * Desc: 设置空页面的内容，文本，图片，按钮等

     *
     * @param emptyView 空页面EmptyView
     */
    void setupEmptyView(EmptyView emptyView);

    /**
     * Desc: 如果列表样式不是LinearLayoutManager，重写返回其他layoutManager

     * @return recycler view . layout manager
     */
    RecyclerView.LayoutManager generateLayoutManager();

    /**
     * Desc: 创建RecyclerView的Adapter

     * @return base adapter
     */
    BaseQuickAdapter<T, ViewHolder> generateAdapter();

    void fetchData(int page);

}
