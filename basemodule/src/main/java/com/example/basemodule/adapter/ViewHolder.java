package com.example.basemodule.adapter;

import android.view.View;


import com.chad.library.adapter.base.BaseViewHolder;

import kotlin.jvm.functions.Function1;

public class ViewHolder extends BaseViewHolder {

    private BaseAdapter mBaseAdapter;

    public ViewHolder(View view) {
        super(view);
    }

    public BaseAdapter getBaseAdapter() {
        return mBaseAdapter;
    }

    public void setBaseAdapter(BaseAdapter baseAdapter) {
        mBaseAdapter = baseAdapter;
    }

    public ViewHolder loadImage(int id, String url) {
//        ImageLoadHelper.load(ActivityHelper.getGlobalApplicationContext(), url, (ImageView) getView(id));
        return this;
    }

    public ViewHolder loadImageWithCenterCrop(int id, String url) {
//        Glide.with(ActivityHelper.getGlobalApplicationContext())
//                .load(url)
//                .centerCrop()
//                .into((ImageView) getView(id));
        return this;
    }

    public void setViewClickListener(int id, final Function1<View, Void> callback) {
        getView(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.invoke(v);
            }
        });
    }
}
