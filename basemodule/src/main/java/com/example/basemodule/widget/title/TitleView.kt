package com.example.basemodule.widget.title

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.basemodule.R
import com.example.basemodule.widget.BaseCustomView
import kotlinx.android.synthetic.main.base_view_title.view.*

class TitleView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr), BaseCustomView<String>, View.OnClickListener {


    //行为响应
    private var actionListener: TitleActionListener? = null
    private var mView: View = LayoutInflater.from(context).inflate(R.layout.base_view_title, this)

    init {
        initView()
        initData()
        initListener()
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
        mView.base_tv_title_left_title.setOnClickListener(this)
        mView.base_iv_title_left_icon.setOnClickListener(this)
        mView.base_tv_title_right_title.setOnClickListener(this)
        mView.base_iv_title_right_icon.setOnClickListener(this)
        mView.base_tv_title_center_title.setOnClickListener(this)
        mView.base_cl_title_root.setOnClickListener(this)
    }

    override fun setData(entity: String?) {
    }

    //左侧文案
    fun setLeftTitle(text: String) {
        mView.base_tv_title_left_title.text = text
    }

    //左侧图标
    fun setLeftIcon(imResurce: Int) {
        mView.base_iv_title_left_icon.setImageResource(imResurce)
    }

    //右侧文案
    fun setRightTitle(text: String) {
        mView.base_tv_title_right_title.text = text
    }

    //右侧图标
    fun setRightIcon(imResurce: Int) {
        mView.base_iv_title_right_icon.setImageResource(imResurce)
    }

    //中间文案
    fun setCenterTitle(text: String) {
        mView.base_tv_title_center_title.text = text
    }

    //事件响应
    fun setAction(listener: TitleActionListener?) {
        actionListener = listener
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.base_tv_title_left_title -> {
                actionListener?.onLeftTitleAction(v)
            }
            R.id.base_iv_title_left_icon -> {
                actionListener?.onLeftIconAction(v)
            }
            R.id.base_tv_title_right_title -> {
                actionListener?.onRightTitleAction(v)
            }
            R.id.base_iv_title_right_icon -> {
                actionListener?.onRightIconAction(v)
            }
            R.id.base_tv_title_center_title -> {
                actionListener?.onCenterAction(v)
            }
            R.id.base_cl_title_root -> {
                actionListener?.onTitleAction(v)
            }
            else -> {
            }
        }
    }
}