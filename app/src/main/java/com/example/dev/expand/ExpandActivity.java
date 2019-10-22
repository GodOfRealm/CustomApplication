package com.example.dev.expand;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-23
 * Company: @有门网络科技
 * Update Comments:
 */
public class ExpandActivity extends BaseActivity {
    RecyclerView rcvList;

    @Override
    protected void initView() {
        setContentView(R.layout.expand_activity_test);
        rcvList = findViewById(R.id.expand_rcv_test_list);
    }

    @Override
    protected void initData() {
        ExpandableItemAdapter adapter = new ExpandableItemAdapter(generateData());
        rcvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvList.setAdapter(adapter);
        adapter.expandAll();
    }

    @Override
    protected void initListener() {

    }

    private ArrayList generateData() {
        int lv0Count = 9;
        int lv1Count = 3;

        ArrayList res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i);
            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item("Level 1 item: " + j, "(no animation)");
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }

}
