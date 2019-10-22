package com.example.dev.mvpTest;

import com.example.dev.base.BaseActivity;
import com.example.dev.delegate.BaseDelegate;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-31
 * Company: @有门网络科技
 * Update Comments:
 */
public class TestActivity extends BaseActivity implements TestContract.View {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        TestPresenter testPresenter = new TestPresenter();
        testPresenter.attachView(this);
        mDelegate.addPresenter(testPresenter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess() {

    }
}
