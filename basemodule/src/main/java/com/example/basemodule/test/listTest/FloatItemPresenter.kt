package com.example.basemodule.test.listTest

import com.example.basemodule.R
import com.example.basemodule.adapter.ItemPresenter
import com.example.basemodule.adapter.ViewHolder

class FloatItemPresenter :ItemPresenter<String>() {
    override fun getLayoutRes(): Int {
        return R.layout.test_item
    }

    override fun convert(holder: ViewHolder?, t: String?) {
    }
}