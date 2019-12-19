package com.example.dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.dev.myapplication.R;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.*;

public class MainActivity extends AppCompatActivity {

    private SwipeRecyclerView mRcvList;
    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        mRcvList = (SwipeRecyclerView) findViewById(R.id.main_rcv_list);
        mRcvList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TestAdapter();
        mAdapter.setHeaderAndEmpty(true);
        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(i + "fuck");
//        }
        mAdapter.setNewData(list);
        mAdapter.setHeaderView(View.inflate(MainActivity.this, R.layout.head, null));
        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.empty,null );
        FrameLayout.LayoutParams te = new FrameLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT);
        inflate.setLayoutParams(te);
        mAdapter.setEmptyView(inflate);


        mRcvList.setSwipeMenuCreator(new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int position) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                deleteItem.setText("删除");
                deleteItem.setBackgroundColorResource(R.color.colorPrimary);
                leftMenu.addMenuItem(deleteItem); // 在Item左侧添加一个菜单。

                SwipeMenuItem share = new SwipeMenuItem(getApplicationContext());
                share.setText("分享");
                share.setBackgroundColorResource(R.color.colorPrimary);
                rightMenu.addMenuItem(share);
            }
        });
        mRcvList.setOnItemMenuClickListener(new OnItemMenuClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge, int adapterPosition) {
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection();
                if (direction == SwipeRecyclerView.LEFT_DIRECTION) {
                    Toast.makeText(getApplicationContext(), "left", Toast.LENGTH_SHORT).show();
                } else if (direction == SwipeRecyclerView.RIGHT_DIRECTION) {
                    Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT).show();

                }
            }
        });
        mRcvList.setAdapter(mAdapter);

    }
}
