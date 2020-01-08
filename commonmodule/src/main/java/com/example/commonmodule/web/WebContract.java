package com.example.commonmodule.web;

import android.app.Activity;
import android.widget.LinearLayout;

import com.just.agentweb.IWebLayout;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;


public interface WebContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View {

        Activity getActivity();

        String getUrl();

        IWebLayout getWebLayout();

        LinearLayout getLinearLayout();

        WebChromeClient getWebChromeClient();

        WebViewClient getWebViewClient();

    }


}
