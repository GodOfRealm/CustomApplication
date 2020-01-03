package com.example.basemodule.widget;


public interface BaseCustomView<T> {
    public void initView();

    public void initData();

    public void initListener();

    public void setData(T entity);
}
