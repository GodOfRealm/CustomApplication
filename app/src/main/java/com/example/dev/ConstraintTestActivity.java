package com.example.dev;

import android.support.constraint.Group;
import android.widget.Button;

import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.R;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/24
 * Company: @有门网络科技
 * Update Comments:
 */
public class ConstraintTestActivity extends BaseActivity {

    private Group mGpTest;
    private Button mBtnAction;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_constraint_test);
        mGpTest = findViewById(R.id.constraint_group);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
