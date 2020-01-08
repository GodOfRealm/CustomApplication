package com.example.basemodule.widget.title

import android.view.View

//titlle 点击响应事件
interface TitleActionListener {
    fun onLeftTitleAction(view: View)
    fun onLeftIconAction(view: View)
    fun onCenterAction(view: View)
    fun onRightTitleAction(view: View)
    fun onRightIconAction(view: View)
    fun onTitleAction(view: View)
}