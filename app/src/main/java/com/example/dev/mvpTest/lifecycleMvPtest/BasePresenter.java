package com.example.dev.mvpTest.lifecycleMvPtest;

import android.arch.lifecycle.LifecycleOwner;

import org.jetbrains.annotations.NotNull;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-31
 * Company: @有门网络科技
 * Update Comments:
 */
public class BasePresenter<V extends BaseView>implements BaseLifecycleObserver {
    protected V mView;

    @Override
    public void onAny(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onCreate(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onStart(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onDestory(@NotNull LifecycleOwner owner) {

    }
}
