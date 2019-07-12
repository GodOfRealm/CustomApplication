package com.miguan.pick.core.widget.dialog;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;

import com.miguan.pick.core.R;

import java.io.Serializable;

/**
 * Desc:通用弹窗
 * Author: zhangwenshun
 * Date: 2019/5/22
 * Company: @有门网络科技
 * Update Comments:
 */
public class CommonAlertDialog {

    public static void newInstance(final Builder builder, FragmentManager fragmentManager) {
        new CommonDialog.Builder()
                .setLayoutRes(R.layout.common_alert_dialog)
                .setCancelableOutside(builder.isCancelableOutside())
                .addOnClickListener(R.id.uikit_common_alert_dialog_tv_left, R.id.uikit_common_alert_dialog_tv_right,
                        R.id.uikit_common_alert_dialog_iv_close)
                .setOnViewClickListener(new OnCommonDialogViewClickListener() {
                    @Override
                    public void onViewClick(CommonDialogBindViewHolder viewHolder, View view, CommonDialog tDialog) {
                        if (builder.getCommonAlertListener() != null) {
                            int id = view.getId();
                            if (id == R.id.uikit_common_alert_dialog_iv_close) {

                                builder.getCommonAlertListener().onClosed(view, tDialog);

                            } else if (id == R.id.uikit_common_alert_dialog_tv_left) {
                                builder.getCommonAlertListener().onLeft(view, tDialog);

                            } else if (id == R.id.uikit_common_alert_dialog_tv_right) {
                                builder.getCommonAlertListener().onRight(view, tDialog);
                            }
                        }

                    }
                })
                .setBindViewListener(new OnCommonDialogBindViewListener() {
                    @Override
                    public void bindView(CommonDialogBindViewHolder viewHolder, CommonDialog dialog) {
                        //数据设置
                        if (!TextUtils.isEmpty(builder.getContentString())) {
                            viewHolder.setText(R.id.uikit_common_alert_dialog_tv_message, builder.getContentString());
                        }
                        if (!TextUtils.isEmpty(builder.getLeftString())) {
                            viewHolder.setText(R.id.uikit_common_alert_dialog_tv_left, builder.getLeftString());
                        }
                        if (!TextUtils.isEmpty(builder.getRightString())) {
                            viewHolder.setText(R.id.uikit_common_alert_dialog_tv_right, builder.getRightString());
                        }
                        if (!TextUtils.isEmpty(builder.getTitleString())) {
                            if (builder.isHasTip()) {
                                viewHolder.setText(R.id.uikit_common_alert_dialog_tv_tip, builder.getTitleString());
                            }
                        }
                        //单双按钮
                        if (builder.isSingle()) {
                            viewHolder.setGone(R.id.uikit_common_alert_dialog_tv_left, false);
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) (viewHolder.getView(R.id
                                    .uikit_common_alert_dialog_tv_left)
                                    .getLayoutParams());
                            layoutParams.leftMargin = dialog.getContext().getResources()
                                    .getDimensionPixelSize(R.dimen.bdp_50);
                            layoutParams.rightMargin = dialog.getContext().getResources()
                                    .getDimensionPixelSize(R.dimen.bdp_50);
                        }

                        //有无顶部提示
                        viewHolder.setVisible(R.id.uikit_common_alert_dialog_tv_tip, builder.isHasTip());
                        viewHolder.setVisible(R.id.uikit_common_alert_dialog_v_top_line, builder.isHasTip());

                        //是否显示关闭按钮
                        if (builder.isShowClose()) {
                            viewHolder.setVisible(R.id.uikit_common_alert_dialog_iv_close, true);
                        }
                    }
                }).show(fragmentManager);

    }


    public static class Builder implements Serializable {

        private String mLeftString;
        private String mRightString;
        private String mTitleString;
        private String mContentString;
        private boolean mIsSingle;
        private boolean mHasTip;
        private boolean mShowClose;
        private CommonAlertListener mCommonAlertListener;
        private boolean mCancelableOutside;

        public String getTitleString() {
            return mTitleString;
        }

        public String getContentString() {
            return mContentString;
        }

        public String getLeftString() {
            return mLeftString;
        }

        public String getRightString() {
            return mRightString;
        }

        public boolean isSingle() {
            return mIsSingle;
        }

        public boolean isHasTip() {
            return mHasTip;
        }

        public boolean isShowClose() {
            return mShowClose;
        }

        public CommonAlertListener getCommonAlertListener() {
            return mCommonAlertListener;
        }

        public Builder setCancelableOutside(boolean cancelableOutside) {
            mCancelableOutside = cancelableOutside;
            return this;
        }

        public boolean isCancelableOutside() {
            return mCancelableOutside;
        }

        public Builder setRightString(String rightString) {
            mRightString = rightString;
            return this;
        }

        public Builder setLeftString(String leftString) {
            mLeftString = leftString;
            return this;
        }

        public Builder setTitleString(String titleString) {
            mTitleString = titleString;
            return this;
        }

        public Builder setSingleType(boolean isSingle) {
            mIsSingle = isSingle;
            return this;
        }

        public Builder setHasTip(boolean hasTip) {
            mHasTip = hasTip;
            return this;
        }

        public Builder setShowClose(boolean showClose) {
            mShowClose = showClose;
            return this;
        }

        public Builder setContentString(String contentString) {
            mContentString = contentString;
            return this;
        }

        public Builder setCommonAlertListener(CommonAlertListener commonAlertListener) {
            mCommonAlertListener = commonAlertListener;
            return this;
        }

        public void show(FragmentManager fragmentManager) {
            CommonAlertDialog.newInstance(this, fragmentManager);
        }
    }

}
