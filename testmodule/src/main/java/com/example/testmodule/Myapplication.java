package com.example.testmodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/20
 * Company: @有门网络科技
 * Update Comments:
 */
public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
