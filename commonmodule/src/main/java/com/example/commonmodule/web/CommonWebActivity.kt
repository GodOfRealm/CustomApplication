package com.example.commonmodule.web

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.webkit.ConsoleMessage
import android.webkit.JsResult
import android.webkit.WebView
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.basemodule.base.BaseActivity
import com.example.commonmodule.R
import com.example.commonmodule.constant.ARouterPaths
import com.example.commonmodule.constant.ExtraConstant
import com.just.agentweb.IWebLayout
import com.just.agentweb.WebChromeClient
import com.just.agentweb.WebViewClient
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.common_activity_web.*

@Route(path = ARouterPaths.COMMON_WEB)
class CommonWebActivity : BaseActivity(), WebContract.View {
    val mWebDelegate by lazy { WebDelegate(this) }
    private var mSmartRefreshLayout: SmartRefreshLayout? = null

    /**
     * 地址
     */
    @JvmField
    @Autowired(name = ExtraConstant.WEB_URL)
    var mUrl: String = ""


    override fun getLayoutId(): Int {
        return R.layout.common_activity_web
    }

    override fun init(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
        mWebDelegate.loadUrl()
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun getUrl(): String {
        return mUrl
    }

    override fun getWebLayout(): IWebLayout<*, *> {
        val webLayout = WebLayout(this)
        mSmartRefreshLayout = webLayout.layout as SmartRefreshLayout
        mSmartRefreshLayout?.setOnRefreshListener {
            mWebDelegate.reload()
        }
        mSmartRefreshLayout?.setEnableLoadMore(false)

        return webLayout
    }

    override fun getLinearLayout(): LinearLayout {
        return common_ll_web_root
    }

    override fun getWebChromeClient(): WebChromeClient {
        return object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView, title: String) {
                super.onReceivedTitle(view, title)
                if (!TextUtils.isEmpty(title)) {
                    common_tiv_web_title.setCenterTitle(title)
                }
            }
        }
    }

    override fun getWebViewClient(): WebViewClient {
        return object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                mSmartRefreshLayout?.finishRefresh()
            }
        }
    }

}