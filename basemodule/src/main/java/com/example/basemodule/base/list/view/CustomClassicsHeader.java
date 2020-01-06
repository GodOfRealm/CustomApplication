package com.example.basemodule.base.list.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testmodule.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;


public class CustomClassicsHeader extends LinearLayout implements RefreshHeader {

    private TextView mHeaderText;//标题文本
    private ImageView mArrowView;//下拉箭头
    private ImageView mProgressView;//刷新动画视图
    private ProgressDrawable mProgressDrawable;//刷新动画
    private TextView mRemindMessage;//刷新完成后提示view（类似：已为你更新最新内容）
    private RemindEntity mRemindEntity;
    private boolean mHideArrow = false;//是否隐藏箭头

    public CustomClassicsHeader(Context context) {
        this(context, null);
    }

    public CustomClassicsHeader(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        setGravity(Gravity.CENTER);
        mHeaderText = new TextView(context);
        mHeaderText.setTextSize(12);
        mHeaderText.setTextColor(0xff989898);
        mProgressDrawable = new ProgressDrawable();
        mArrowView = new ImageView(context);
        mProgressView = new ImageView(context);
        mProgressView.setImageDrawable(mProgressDrawable);
        mArrowView.setImageResource(R.mipmap.pic_renovate);
        addView(mProgressView, DensityUtil.dp2px(20), DensityUtil.dp2px(20));
        addView(mArrowView, DensityUtil.dp2px(20), DensityUtil.dp2px(20));
        addView(mHeaderText, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        //设置文字与图标之间的间距
        MarginLayoutParams p = (MarginLayoutParams) mHeaderText.getLayoutParams();
        p.setMargins(DensityUtil.dp2px(20), 0, 0, 0);
        mHeaderText.requestLayout();

        mRemindMessage = new TextView(getContext());
        mRemindMessage.setGravity(Gravity.CENTER);
        mRemindMessage.setVisibility(GONE);
        addView(mRemindMessage, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        setMinimumHeight(DensityUtil.dp2px(45));
        setArrowViewShow();
    }

    @NonNull
    public View getView() {
        return this;//真实的视图就是自己，不能返回null
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout layout, int height, int maxDragHeight) {
        mProgressDrawable.start();//开始动画
    }

    @Override
    public int onFinish(@NonNull RefreshLayout layout, boolean success) {
        mProgressDrawable.stop();//停止动画
        mProgressView.setVisibility(GONE);//隐藏动画
        if (mRemindEntity != null) {
            mHeaderText.setVisibility(GONE);
            mRemindMessage.setVisibility(VISIBLE);
        } else {
            mHeaderText.setVisibility(VISIBLE);
            mRemindMessage.setVisibility(GONE);
        }
        return mRemindEntity == null ? 0 : mRemindEntity.getAnimeTime() * 1000;//延迟毫秒之后再弹回
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        mHeaderText.setVisibility(VISIBLE);
        switch (newState) {
            case None:
                mRemindMessage.setVisibility(GONE);
                break;
            case PullDownToRefresh:
                mHeaderText.setText("下拉刷新");
//                mArrowView.setVisibility(VISIBLE);
                setArrowViewShow();//显示下拉箭头
                mProgressView.setVisibility(mHideArrow ? VISIBLE : GONE);//隐藏动画
                mArrowView.animate().rotation(0);//还原箭头方向
                break;
            case Refreshing:
                mHeaderText.setText("加载中");
                mProgressView.setVisibility(VISIBLE);//显示加载动画
                mArrowView.setVisibility(GONE);//隐藏箭头
                break;
            case ReleaseToRefresh:
                mProgressView.setVisibility(mHideArrow ? VISIBLE : GONE);
                mHeaderText.setText(mHideArrow ? "加载中" : "释放更新");
                mArrowView.animate().rotation(180);//显示箭头改为朝上
                break;
            case RefreshFinish:
                mHideArrow = false;
                break;
        }
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public void setRemindMessage(RemindEntity upHintInfo) {
        if (upHintInfo == null) {
            return;
        }
        mRemindEntity = upHintInfo;
        mRemindMessage.setText(mRemindEntity.getTitle());
        mRemindMessage.setTextColor(Color.parseColor(mRemindEntity.getTitleColor()));
        mRemindMessage.setBackgroundColor(Color.parseColor(mRemindEntity.getBgColor()));
    }

    /**
     * 是否显示箭头
     *
     * @param showArrow
     */
    public void setShowArrow(boolean showArrow) {
        mHideArrow = showArrow;
    }

    private void setArrowViewShow() {
        mArrowView.setVisibility(mHideArrow ? GONE : VISIBLE);
    }
}

