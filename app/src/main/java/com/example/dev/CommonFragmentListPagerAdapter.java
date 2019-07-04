package com.example.dev;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/25
 * Company: @有门网络科技
 * Update Comments:
 */
public class CommonFragmentListPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public CommonFragmentListPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}