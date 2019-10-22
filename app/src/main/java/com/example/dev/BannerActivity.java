package com.example.dev;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-10-10
 * Company: @有门网络科技
 * Update Comments:
 */
public class BannerActivity extends BaseActivity {

    private ConvenientBanner mBanner;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_banner);
        mBanner = findViewById(R.id.convenientBanner);
    }

    @Override
    protected void initData() {
//        BlockingQueue<String> ueue_List = new LinkedBlockingQueue<String>();
//
//
//
//        List<String> arrayList = new ArrayList<String>();
//
//        ueue_List.drainTo(arrayList, max);//每次取5000个，不够就取剩下的



        List<BannerEntity> list = new ArrayList();

        BannerEntity entity = new BannerEntity();
        BannerEntity entity2 = new BannerEntity();
        BannerEntity entity3 = new BannerEntity();

        List<String> itemlist = new ArrayList();
        List<String> itemlist2 = new ArrayList();
        List<String> itemlist3 = new ArrayList();


        for (int i = 0; i < 8; i++) {
            itemlist.add(i + "");
        }
        entity.setList(itemlist);
        itemlist2.add("");
        itemlist3.add("");

        entity2.setList(itemlist2);
        entity3.setList(itemlist3);

        list.add(entity);
//        list.add(entity2);
//        list.add(entity3);


        mBanner.setCanLoop(false);
        mBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new BannerHolder();
            }
        }, list)
                .setPageIndicator(new int[]{R.drawable.point_gray_kong, R.drawable.point_gray})

        ;
    }

    @Override
    protected void initListener() {

    }


    class BannerHolder implements Holder<BannerEntity> {

        private RecyclerView mRecyclerView;
        private BannerAdapter mAdapter;

        @Override
        public View createView(Context context) {
            mRecyclerView = new RecyclerView(context);
            mAdapter = new BannerAdapter();
            mRecyclerView.setLayoutManager(new GridLayoutManager(context, 4));
            mRecyclerView.setAdapter(mAdapter);
            return mRecyclerView;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerEntity data) {
            mAdapter.setNewData(data.getList());
        }
    }
}
