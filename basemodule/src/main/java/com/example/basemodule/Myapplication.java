package com.example.basemodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;

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
        Utils.init(this);
    }
}
