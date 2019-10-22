package com.example.dev.expand;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.dev.myapplication.R;

import java.util.List;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-23
 * Company: @有门网络科技
 * Update Comments:
 */
public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = ExpandableItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with * some initialization data. * * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.expand_level_zero_layout);
        addItemType(TYPE_LEVEL_1, R.layout.expand_level_one_layout);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                holder.setText(R.id.expand_tv_zero_title, ((Level0Item) item).title);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int adapterPosition = holder.getAdapterPosition();
                        if (((Level0Item) item).isExpanded()) {
                            collapse(adapterPosition);

                        } else {
                            expand(adapterPosition);
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:

                break;

        }
    }
}
