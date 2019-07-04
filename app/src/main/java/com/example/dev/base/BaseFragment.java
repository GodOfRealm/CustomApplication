package com.example.dev.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/20
 * Company: @有门网络科技
 * Update Comments:
 */

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public abstract class BaseFragment extends Fragment {
    /**
     * Fragment是否已经绑定
     */
    protected boolean isViewInitiated;
    /**
     * 用户是否可见
     */
    protected boolean isVisibleToUser;
    /**
     * 是否绑定数据
     */
    protected boolean isDataInitiated;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    /**
     * 是时候绑定数据了
     */
    public abstract void fetchData();

    /**
     * 是时候准备数据了
     *
     * @return
     */
    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }
}
