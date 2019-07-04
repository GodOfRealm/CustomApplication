package com.miguan.pick.core.base;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.miguan.pick.core.util.IImageLoader;

/**
 * <p>
 * describe:
 *
 * </p>
 *
 * @author qiurong
 * @date 2018/7/22
 * @since 2.1.4
 */
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
        IImageLoader.loadImage((ImageView) getView(id), url);
        return this;
    }

    public ViewHolder loadImage(int id, String url, int defaultRes) {
        IImageLoader.loadImage((ImageView) getView(id), url, defaultRes);
        return this;
    }

    public ViewHolder setVisible(boolean visible, int id) {
        getView(id).setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }
}
