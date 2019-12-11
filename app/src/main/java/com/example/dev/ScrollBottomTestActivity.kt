package com.example.dev

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SizeUtils
import com.example.dev.base.BaseActivity
import com.example.dev.myapplication.R
import kotlinx.android.synthetic.main.activity_scroll_bottom_test.*
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout


/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-12-11
 * Company: @有门网络科技
 * Update Comments:
 */
class ScrollBottomTestActivity : BaseActivity() {
    var mAdapter = ScrollBottomTestAdapter()
    override fun initView() {
        setContentView(R.layout.activity_scroll_bottom_test)

    }

    override fun initData() {
        scroll_rcv_list.also {
            it.layoutManager = GridLayoutManager(it.context, 4)
            it.adapter = mAdapter
            it.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.left = SizeUtils.dp2px(10f)
                    outRect.right = SizeUtils.dp2px(10f)
                    outRect.bottom = SizeUtils.dp2px(10f)
                }
            })
        }
        var dataList = mutableListOf<String>()
        for (index in 1..50) {
            dataList.add(index.toString())

        }
        mAdapter.setNewData(dataList)
    }

    override fun initListener() {
        scroll_iv_preview.setOnClickListener {
            LogUtils.e("fuck")
        }
        uikit_abl_base_coordinator_appbarLayout.post {
            val params = uikit_abl_base_coordinator_appbarLayout.layoutParams as CoordinatorLayout.LayoutParams
            val behavior = params.behavior as AppBarLayout.Behavior
            behavior!!.setDragCallback(object : AppBarLayout.Behavior.DragCallback() {
                override fun canDrag(appBarLayout: AppBarLayout): Boolean {
                    return false
                }
            })
        }


    }
}