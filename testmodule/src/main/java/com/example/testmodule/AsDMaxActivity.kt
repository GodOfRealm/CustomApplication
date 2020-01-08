package com.example.testmodule

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.basemodule.adapter.BaseMixAdapter
import com.example.basemodule.adapter.ViewHolder
import com.example.basemodule.base.list.BaseListActivity
import com.example.basemodule.test.listTest.FloatItemPresenter
import com.example.basemodule.test.listTest.IntItemPresenter
import com.example.basemodule.test.listTest.StringItemPresenter
import com.example.basemodule.widget.EmptyView
import com.example.basemodule.widget.title.SimpleTitleActionListener
import com.example.basemodule.widget.title.TitleView

@Route(path = "/max/activity")
class AsDMaxActivity : BaseListActivity<Any>() {
    override fun begin() {
//        var titleDelegate = TitleView(this)
//        rootView.addView(titleDelegate, 0)
//        titleDelegate.setAction(object : SimpleTitleActionListener() {
//            override fun onLeftTitleAction(view: View) {
//                LogUtils.e("fuckonLeftTitleAction")
//            }
//
//            override fun onTitleAction(view: View) {
//                LogUtils.e("fuckonTitleAction")
//
//            }
//        })

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