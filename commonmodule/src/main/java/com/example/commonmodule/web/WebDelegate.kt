package com.example.commonmodule.web

import android.widget.LinearLayout
import com.example.commonmodule.R
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient

class WebDelegate(var mView: WebContract.View) {
    private lateinit var mAgentWeb: AgentWeb

    fun loadUrl() {
        mAgentWeb = AgentWeb.with(mView.activity)
                .setAgentWebParent(mView.linearLayout, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator(mView.activity.resources.getColor(R.color.colorPrimary))
                .setWebChromeClient(mView.webChromeClient)
                .setWebViewClient(mView.webViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setWebLayout(mView.webLayout)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(mView.url)
        mAgentWeb.jsInterfaceHolder.addJavaObject("android", AndroidInterface(mView.activity))

    }

    fun reload() {
        mAgentWeb.urlLoader.reload()
    }

    fun onDestory() {
        mAgentWeb.webLifeCycle.onDestroy()
    }

    fun getAgentWeb(): AgentWeb {
        return mAgentWeb
    }
}