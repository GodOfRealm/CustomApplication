package com.example.basemodule.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SonnyJack on 2018/7/3 17:00.
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
