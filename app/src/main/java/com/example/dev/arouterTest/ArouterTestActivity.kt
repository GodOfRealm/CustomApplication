package com.example.dev.arouterTest

import com.alibaba.android.arouter.launcher.ARouter
import com.example.dev.base.BaseActivity
import com.example.dev.myapplication.R
import kotlinx.android.synthetic.main.activity_arouter_test.*

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-12-19
 * Company: @有门网络科技
 * Update Comments:
 */
class ArouterTestActivity : BaseActivity() {
    override fun initView() {
        setContentView(R.layout.activity_arouter_test)
        aroute_tv_test.setOnClickListener {
            ARouter.getInstance().build("/test/banner").navigation()

        }
        aroute_tv_module.setOnClickListener {
            ARouter.getInstance().build("/module/activity").navigation()

        }
        aroute_tv_base.setOnClickListener {
            ARouter.getInstance().build("/base/activity").navigation()
        }

    }


    override fun initData() {
    }

    override fun initListener() {
    }
}