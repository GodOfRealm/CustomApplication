package com.example.commonmodule.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.webkit.JavascriptInterface;

import com.blankj.utilcode.util.PhoneUtils;

/**
 * Desc: 暴露给JS调用的方法

 * Update Comments:
 */
public class AndroidInterface {

    private Activity mActivity;


    public AndroidInterface(Activity activity) {
        mActivity = activity;
    }





    /**
     * Desc:获取设备号

     * @return string
     */
    @JavascriptInterface
    public String getDeviceNumber() {
        return getImei();
    }

    @SuppressLint("MissingPermission")
    public String getImei() {
        String imei = "";
        try {
            imei = PhoneUtils.getIMEI();
        } catch (Exception ignore) {

        }
        return imei;
    }

}
