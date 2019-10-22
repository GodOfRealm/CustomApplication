package com.example.dev.widget.radius;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dev.myapplication.R;


/**
 * Desc: 列表页面的空页面，包含缺省图，提示文本，重试按钮
 * <p>
 * <p>
 * Author: QiuRonaC
 * Date: 2018-06-28
 * Copyright: Copyright (c) 2013-2018
 * Company: @米冠网络
 * Update Comments:
 */
public class EmptyView extends ConstraintLayout {
    private OnRetryListener listener;

    private TextView tvEmpty;
    private ImageView ivEmpty;
    private TextView btnEmpty;

    {
        View.inflate(getContext(), R.layout.base_empty_view, this);
        initView();
    }

    private void initView() {
        btnEmpty = findViewById(R.id.btn_retry);
        tvEmpty = findViewById(R.id.tv_des);
        ivEmpty = findViewById(R.id.img_empty);

//        btnEmpty.setOnClickListener((view) -> {
//            if (listener != null) {
//                listener.onRetry();
//            }
//        });
    }

    public EmptyView(Context context) {
        super(context);
    }

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Desc: 设置重试按钮点击监听
     * <p>
     * Author: QiuRonaC
     * Date: 2018-06-28
     *
     * @param listener retry button click listener
     */
    public EmptyView setOnRetryListener(OnRetryListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Desc:设置空提示文本
     * <p>
     * Author: QiuRonaC
     * Date: 2018-06-28
     *
     * @param text empty text
     */
    public EmptyView setEmptyText(String text) {
        tvEmpty.setText(text);
        return this;
    }

    /**
     * Desc:设置空图片
     * <p>
     * Author: QiuRonaC
     * Date: 2018-06-28
     *
     * @param resource empty image
     */
    public EmptyView setEmptyImageResource(int resource) {
        ivEmpty.setImageResource(resource);
        return this;
    }

    /**
     * Desc: 设置重试按钮文本
     * <p>
     * Author: QiuRonaC
     * Date: 2018-06-28
     *
     * @param text empty Button text
     * @return empty view
     */
    public EmptyView setRetryText(String text) {
        btnEmpty.setVisibility(VISIBLE);
        btnEmpty.setText(text);
        return this;
    }

    /**
     * Desc: 设置重试按钮的显示与隐藏
     * <p>
     * Author: QiuRonaC
     * Date: 2018-06-28
     *
     * @param visibility visibility
     */
    public EmptyView setRetryButtonVisibility(int visibility) {
        btnEmpty.setVisibility(visibility);
        return this;
    }

    /**
     * Desc: 设置空页面的背景颜色
     * <p>
     * Author: 廖培坤
     * Date: 2018-07-25
     *
     * @param color
     * @return empty view
     */
    public EmptyView setLayoutBackgroundColor(int color) {
        setBackgroundResource(color);
        return this;
    }

    public interface OnRetryListener {
        void onRetry();
    }
}
