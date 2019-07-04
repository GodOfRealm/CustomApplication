package com.example.dev;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.dev.myapplication.R;

/**
 * Desc:打卡选择弹窗dialog
 * Author: zhangwenshun
 * Date: 2019/5/21
 * Company: @有门网络科技
 * Update Comments:
 */
public class SelectClockInDialog extends Dialog {

    //列表视图控件
    private View mView;


    public SelectClockInDialog(@NonNull Context context) {
        super(context, R.style.BottomDialogStyle);
        init();
    }


    /**
     * 初始化视图
     */
    private void init() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ViewGroup.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM;
        window.setAttributes(attributes);

        mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_bottom_test, null);

        setContentView(mView);
        initView(mView);

    }



    /**
     * 获取view
     */
    private void initView(View view) {

    }

    /**
     * 修改弹窗高度
     */
    private void setDialogHeight(int height) {
        WindowManager.LayoutParams p = this.getWindow().getAttributes();  //获取对话框当前的参数值
        p.height = ScreenUtil.dip2px(getContext(), height);
        this.getWindow().setAttributes(p);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        Window window = getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
//        window.getDecorView().findViewById(android.R.id.content).setBackgroundResource(android.R.color.transparent);

    }

}
