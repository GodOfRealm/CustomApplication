package com.example.dev.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Desc:懒加载fragment
 * Author: zhangwenshun
 * Date: 2019/6/25
 * Company: @有门网络科技
 * Update Comments:
 */
public abstract class BaseLazyFragment extends Fragment {
    //该页面是否已经准备完毕
    private boolean isPrepared;
    //该fragment是否已经执行过懒加载
    private boolean isLazyLoaded;

    //数据懒加载
    public abstract void onLazyLoad();

    //初始化布局文件
    public abstract int getLayoutId();

    //初始化视图
    public abstract void initView();

    //初始化数据
    public abstract void initData();

    private void lazyLoad() {
        if (getUserVisibleHint() && isPrepared && !isLazyLoaded) {
            isLazyLoaded = true;
            onLazyLoad();
        }
    }

    /*
     *fragment生命周期中onViewCreated之后的方法 在这里调用一次懒加载 避免第一次可见不加载数据
     * setUserVisibleHint有可能在onCreateView之前调用，而onViewCreated在onCreateView之后调用，所以当setUserVisibleHint在onCreateView
     * 之前调用isPrepared为fales（并且getLayoutId()为空），就无法调用onLazyLoad（）,所以需要在此处调用。（不需要担心下一个fragment调用这个方法
     * 因为下一个fragment还是不可见状态，所以也无法调用onLazyLoad（））
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    //onCreateView是创建的时候调用，onViewCreated是在onCreateView后被触发的事件，
    // 前后关系就是fragment中的onCreateView和onViewCreated的区别和联系。
    //且onStart运行时间位于onViewCreated之后
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        initView();
        initData();
    }
}