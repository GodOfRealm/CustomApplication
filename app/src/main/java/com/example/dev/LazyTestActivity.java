package com.example.dev;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.R;

import java.util.ArrayList;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/25
 * Company: @有门网络科技
 * Update Comments:
 */
public class LazyTestActivity extends BaseActivity {

    private ViewPager mVpTest;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_lazy_test);
        mVpTest = findViewById(R.id.lazy_vp_test);
    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new LazyTestFragment1());
        fragmentList.add(new LazyTestFragment2());
        CommonFragmentListPagerAdapter mCommonFragmentListPagerAdapter = new CommonFragmentListPagerAdapter(getSupportFragmentManager(), fragmentList);
        mVpTest.setAdapter(mCommonFragmentListPagerAdapter);
    }

    @Override
    protected void initListener() {

    }
}
