package com.example.dev.RefreshTest

import android.content.Context
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.dev.myapplication.R
import com.miguan.pick.core.base.ViewHolder

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-12-23
 * Company: @有门网络科技
 * Update Comments:
 */
class RefreshDelegate<T>(private var mContext: Context) {
    var layoutID = R.layout.common_refresh_layout
    val mView by lazy { View.inflate(mContext, layoutID, null) }
    var mAdaper: BaseQuickAdapter<T, ViewHolder>? = null
    val mPageIndicator = PageIndicator()

    init {

    }

    //获取布局id
    fun getRootID() = layoutID
}