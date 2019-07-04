package com.example.dev;

import android.view.View;
import android.widget.TextView;

import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.R;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/28
 * Company: @有门网络科技
 * Update Comments:
 */
public class BottomSheetDialogTestActivity extends BaseActivity {

    private TextView mTextView;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_bottom_test);
        mTextView = findViewById(R.id.bottom_tv_test);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectClockInDialog bottomSheetDialog = new SelectClockInDialog(BottomSheetDialogTestActivity.this);
                bottomSheetDialog.show();
            }
        });
    }
}
