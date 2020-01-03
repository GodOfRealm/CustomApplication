package com.example.basemodule.widget

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.testmodule.R
import kotlinx.android.synthetic.main.base_empty_view.view.*

class EmptyView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr), BaseCustomView<String> {
    // 刷新回调
    var retryCallback: (() -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.base_empty_view, this)
        initView()
        initData()
        initListener()
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
        base_tv_empty_retry.setOnClickListener {
            retryCallback?.invoke()
        }
    }

    override fun setData(entity: String?) {
    }

    /**
     * Desc:设置空提示文本
     * @param text empty text
     */
    fun setEmptyText(text: String): EmptyView {
        base_tv_empty_des.text = text
        return this
    }

    /**
     * Desc:设置空图片

     * @param resource empty image
     */
    fun setEmptyImageResource(resource: Int): EmptyView {
        base_iv_empty_icon.setImageResource(resource)
        return this
    }

    /**
     * Desc: 设置重试按钮文本

     */
    fun setRetryText(text: String): EmptyView {
        base_tv_empty_retry.visibility = View.VISIBLE
        base_tv_empty_retry.text = text
        return this
    }

    /**
     * Desc: 设置重试按钮的显示与隐藏

     */
    fun setRetryButtonVisibility(visibility: Int): EmptyView {
        base_tv_empty_retry.visibility = visibility
        return this
    }

    /**
     * Desc: 设置空页面的背景颜色
     */
    fun setLayoutBackgroundColor(color: Int): EmptyView {
        setBackgroundResource(color)
        return this
    }
}