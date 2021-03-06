package com.example.dev.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dev.delegate.BaseDelegate;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/20
 * Company: @有门网络科技
 * Update Comments:
 */
public abstract class BaseActivity extends AppCompatActivity {
    public BaseDelegate mDelegate = new BaseDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDelegate.detachView();
    }
}
