package com.example.dev.mvpTest.lifecycleMvPtest;

import android.view.View;
import android.widget.TextView;

import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.R;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-12-18
 * Company: @有门网络科技
 * Update Comments:
 */
public class LifeMvpTestActivity extends BaseActivity implements LifeTestContract.View {
    private LifeTestPresenter mPresenter;
    private TextView mTextView;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_life_test);
        mPresenter = new LifeTestPresenter(this);
        getLifecycle().addObserver(mPresenter);
        mTextView = (TextView) findViewById(R.id.lift_tv_test);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login("asd", "asd");
            }
        });
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
    public void onSuccess(String test) {
        mTextView.setText(test);
    }
}
