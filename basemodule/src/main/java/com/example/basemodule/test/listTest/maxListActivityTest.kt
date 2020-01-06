package com.example.basemodule.test.listTest

import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.basemodule.adapter.BaseMixAdapter
import com.example.basemodule.adapter.ViewHolder
import com.example.basemodule.base.list.BaseListActivity
import com.example.basemodule.widget.EmptyView

class maxListActivityTest : BaseListActivity<Any>() {
    override fun begin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setupEmptyView(emptyView: EmptyView?) {
        emptyView?.setEmptyText("asdasdasds")
    }

    override fun generateAdapter(): BaseQuickAdapter<Any, ViewHolder> {
        val baseMixAdapter = BaseMixAdapter<Any>()
        baseMixAdapter.addItemPresenter(StringItemPresenter())
        baseMixAdapter.addItemPresenter(FloatItemPresenter())
        baseMixAdapter.addItemPresenter(IntItemPresenter())

        return baseMixAdapter
    }

    override fun fetchData(page: Int) {
        var datalist = mutableListOf<Any>()
        datalist.add(1)
        datalist.add("1321")
        datalist.add(1.0f)
        datalist.add("asdasd")
        datalist.add(1.0f)
        datalist.add(1)
        datalist.add(1)
        datalist.add("asdasd")
        datalist.add("asdasd")

        datalist.add(1)
        datalist.add(1)

        datalist.add(1.0f)

        setData(datalist, true, page)
    }

}