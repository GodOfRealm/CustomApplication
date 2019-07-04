package com.example.dev;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dev.myapplication.R;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/6/19
 * Company: @有门网络科技
 * Update Comments:
 */
public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TestAdapter() {
        super(R.layout.item_test);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.main_tv_test_item_message, item);
    }
}
