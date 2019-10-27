package com.example.dev

import com.example.dev.base.BaseActivity
import com.example.dev.myapplication.R
import kotlinx.android.synthetic.main.acvitity_end_with_icon.*

class EndWithIconTestActivity : BaseActivity() {
    override fun initView() {
        setContentView(R.layout.acvitity_end_with_icon)
        end_with_icon.setData("天王盖地虎天王盖地虎天王盖地虎天天王盖地虎天王盖地虎天王盖地虎天天王盖地虎天王盖地虎天王盖地虎天天王盖地虎天王盖地虎天王盖地虎天","asd")
        end_with_test.setData("天王盖地虎天王盖地虎天王盖地虎天天王盖地虎天王盖地虎天王盖地虎天天王盖地虎天王盖地虎天王盖地虎天天王盖地虎天王盖地虎天王盖地虎天","")

    }

    override fun initData() {
    }

    override fun initListener() {
    }
}