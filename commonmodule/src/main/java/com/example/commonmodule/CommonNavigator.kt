package com.example.commonmodule

import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonmodule.constant.ARouterPaths
import com.example.commonmodule.constant.ExtraConstant

class CommonNavigator {
    //打开网页
    fun openWeb(url: String) {
        ARouter.getInstance()
                .build(ARouterPaths.COMMON_WEB)
                .withString(ExtraConstant.WEB_URL, url)
                .navigation()
    }
}