package com.example.basemodule.test.listTest

import android.os.Bundle
import com.example.basemodule.base.BaseActivity
import com.example.testmodule.R

class ListTestFragmntActivity :BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.test_layout_list_frgment
    }

    override fun init(savedInstanceState: Bundle?) {
    }
}