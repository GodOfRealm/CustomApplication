package com.example.basemodule.base.list;

import android.support.annotation.Nullable;
import android.view.ViewGroup;


import java.util.List;

/**
 * Desc: 有列表页面的BaseView

 *
 * @param <T> the type parameter
 */
public interface IBaseListView<T>  {

    /**
     * Desc: 刷新完成更新列表数据

     * @param data    刷新的数据，当刷新失败的时候为空
     * @param success 是否刷新成功
     */
    void onRefreshComplete(@Nullable List<T> data, boolean success);

    /**
     * Desc: 加载更多完成

     * @param data    加载分页的数据，当加载失败的时候为空
     * @param success 是否加载成功
     */
    void onLoadMoreComplete(List<T> data, boolean success);

    /**
     * Desc:是否可下拉刷新

     * @param enable enable
     */
    void setRefreshEnable(boolean enable);

    /**
     * Desc:是否可加载更多

     * @param enable enable
     */
    void setLoadMoreEnable(boolean enable);


    /**
     * Desc: 是否显示无网络的错误页面

     * @param showErrorPage
     */
    void setShowErrorPage(boolean showErrorPage);


    int getCurPage();

    void setData(List<T> data, boolean success,int requestPage);

}
