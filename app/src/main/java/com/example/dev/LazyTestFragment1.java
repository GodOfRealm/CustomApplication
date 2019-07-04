package com.example.dev;

import android.util.Log;

import com.example.dev.base.BaseLazyFragment;
import com.example.dev.myapplication.R;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/25
 * Company: @有门网络科技
 * Update Comments:
 */
public class LazyTestFragment1 extends BaseLazyFragment {
    @Override
    public void onLazyLoad() {
        Log.d("LazyTestFragment1", "fuck");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
