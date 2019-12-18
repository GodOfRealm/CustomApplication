package com.example.dev.mvpTest.lifecycleMvPtest;

import android.arch.lifecycle.LifecycleOwner;

import com.blankj.utilcode.util.LogUtils;

import org.jetbrains.annotations.NotNull;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-12-18
 * Company: @有门网络科技
 * Update Comments:
 */
public class LifeTestPresenter extends BasePresenter<LifeTestContract.View> implements LifeTestContract.Presenter {
    private LifeTestContract.Model mModel;

    public LifeTestPresenter(LifeTestContract.View view) {
        mModel = new LifeTestModel();
        mView = view;
    }

    @Override
    public void login(String username, String password) {
        String login = mModel.login(username, password);
        mView.onSuccess(login);
    }


    @Override
    public void onDestory(@NotNull LifecycleOwner owner) {
        super.onDestory(owner);
        mModel = null;
        mView = null;

    }

    @Override
    public void onCreate(@NotNull LifecycleOwner owner) {
        super.onCreate(owner);
        LogUtils.e("presenter onCreate");
    }

    @Override
    public void onResume(@NotNull LifecycleOwner owner) {
        super.onResume(owner);
        LogUtils.e("presenter onresume");
    }
}
