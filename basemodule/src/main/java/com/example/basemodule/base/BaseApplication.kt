package com.example.basemodule.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.Utils

open class BaseApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
        Utils.init(this)
    }
}