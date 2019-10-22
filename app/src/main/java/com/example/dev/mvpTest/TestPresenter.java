package com.example.dev.mvpTest;

import com.miguan.pick.core.mvp.BasePresenter;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-31
 * Company: @有门网络科技
 * Update Comments:
 */
public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {
    private TestContract.Model model;

    public TestPresenter() {
        model = new TestModel();

    }

    @Override
    public void login(String username, String password) {
        if (!isViewAttached()) {
            return;
        }
        model.login(username, password);
        //根据相应的返回结果,执行mView的相关方法
        mView.onSuccess();
        mView.showLoading();
    }
}
