package com.miguan.pick.core.base;

/**
 * Desc:自定义view基类
 * Author: zhangwenshun
 * Date: 2019/6/27
 * Company: @有门网络科技
 * Update Comments:
 */
public interface BaseCustomView<T> {
    public void initData();

    public void initView();

    public void initListener();

    public void setData(T entity);
}
