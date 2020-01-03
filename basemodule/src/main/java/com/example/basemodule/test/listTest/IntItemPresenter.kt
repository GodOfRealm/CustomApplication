package com.example.basemodule.test.listTest

import com.example.basemodule.adapter.ItemPresenter
import com.example.basemodule.adapter.ViewHolder
import com.example.testmodule.R

class IntItemPresenter :ItemPresenter<Int>() {
    override fun getLayoutRes(): Int {
        return R.layout.test_item_int
    }

    override fun convert(holder: ViewHolder?, t: Int?) {
    }
}