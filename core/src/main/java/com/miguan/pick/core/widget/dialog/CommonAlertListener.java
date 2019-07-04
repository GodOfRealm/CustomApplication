package com.miguan.pick.core.widget.dialog;

import android.view.View;

/**
 * Desc:通用选择弹窗点击回调实现接口
 * Author: zhangwenshun
 * Date: 2019/5/15
 * Company: @有门网络科技
 * Update Comments:
 */
public interface CommonAlertListener {
    void onLeft(View view, CommonDialog tDialog);

    void onRight(View view, CommonDialog tDialog);

    void onClosed(View view, CommonDialog tDialog);
}
