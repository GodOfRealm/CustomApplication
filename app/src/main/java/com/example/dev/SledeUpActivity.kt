package com.example.dev

import android.view.Gravity
import android.widget.LinearLayout
import com.example.dev.base.BaseActivity
import com.example.dev.myapplication.R
import com.mancj.slideup.SlideUp
import com.mancj.slideup.SlideUpBuilder

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-12-10
 * Company: @有门网络科技
 * Update Comments:
 */
class SledeUpActivity : BaseActivity() {
    override fun initView() {

        setContentView(R.layout.activity_slideup_test)

    }

    override fun initData() {
        var test = findViewById<LinearLayout>(R.id.slide_ll_test)
        SlideUpBuilder(test)
                .withStartState(SlideUp.State.HIDDEN)
                .withStartGravity(Gravity.BOTTOM)
                .build()
    }

    override fun initListener() {
    }
}