package com.example.dev;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.dev.myapplication.R;

import java.util.ArrayList;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/28
 * Company: @有门网络科技
 * Update Comments:
 */
public class BottomDialog extends BottomSheetDialog {


    public BottomDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public BottomDialog(@NonNull Context context, double canWithdrawCount) {
        super(context);
        init();
    }

    protected BottomDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }


    private void init() {
        //设置视图
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_bottom_test, null);
        setContentView(view);

        //初始化键盘数据
        ArrayList<String> itemList = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            itemList.add(i + "");
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bottom_rcv_test);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TestAdapter testAdapter = new TestAdapter();
        recyclerView.setAdapter(testAdapter);
        testAdapter.setNewData(itemList);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        Window window = getWindow();
        window.findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);

    }
}
