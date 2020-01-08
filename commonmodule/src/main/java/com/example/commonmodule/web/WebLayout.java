package com.example.commonmodule.web;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.commonmodule.R;
import com.just.agentweb.IWebLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class WebLayout implements IWebLayout {

    private SmartRefreshLayout mSmartRefreshLayout;
    private WebView mWebView;

    public WebLayout(Context context) {
        mSmartRefreshLayout = (SmartRefreshLayout) View.inflate(context, R.layout.common_layout_web, null);
        mWebView = mSmartRefreshLayout.findViewById(R.id.common_web_view);
    }

    @NonNull
    @Override
    public ViewGroup getLayout() {
        return mSmartRefreshLayout;
    }

    @Nullable
    @Override
    public WebView getWebView() {
        return mWebView;
    }

}
