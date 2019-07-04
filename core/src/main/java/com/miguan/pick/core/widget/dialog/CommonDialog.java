package com.miguan.pick.core.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.miguan.pick.core.R;

import java.io.Serializable;

/**
 * Desc:通用弹窗
 * Author: zhangwenshun
 * Date: 2019/5/22
 * Company: @有门网络科技
 * Update Comments:
 */
public class CommonDialog extends DialogFragment {
    public static String EXTRA_BUILDER = "extra_builder";//参数
    private Builder mBuilder;
    private DialogInterface.OnDismissListener mOnDismissListener;
    public OnCommonDialogViewClickListener mOnViewClickListener;

    public static CommonDialog newInstance(Builder builder) {
        CommonDialog dialog = new CommonDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_BUILDER, builder);
        dialog.setArguments(bundle);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CommonDialogTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog alertDialog = builder.create();

        if (getArguments() != null) {
            mBuilder = (Builder) getArguments().getSerializable(EXTRA_BUILDER);
            View view = inflater.inflate(mBuilder.getLayoutRes(), null);
            alertDialog.setView(view);
            initView(view, alertDialog);
        }
        return alertDialog;

    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            //设置宽高
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            if (mBuilder.getWidth() > 0) {
                layoutParams.width = dipToPx(getContext(), mBuilder.getWidth());
            } else {
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            if (mBuilder.getHeight() > 0) {
                layoutParams.height = dipToPx(getContext(), mBuilder.getHeight());
                ;
            } else {
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            window.setAttributes(layoutParams);
        }
    }

    protected void initView(View view, AlertDialog alertDialog) {
        CommonDialogBindViewHolder commonDialogBindViewHolder = new CommonDialogBindViewHolder(view, this);

        setCancelable(!mBuilder.isCancelableOutside());
        if (mBuilder.getOnDismissListener() != null) {
            mOnDismissListener = mBuilder.getOnDismissListener();
        }
        if (mBuilder.getIds() != null && mBuilder.getIds().length > 0) {
            for (int id : mBuilder.getIds()) {
                commonDialogBindViewHolder.addOnClickListener(id);
            }
        }
        if (mBuilder.getOnBindViewListener() != null) {
            mBuilder.getOnBindViewListener().bindView(commonDialogBindViewHolder, this);
        }
        if (mBuilder.getOnViewClickListener() != null) {
            mOnViewClickListener = mBuilder.mOnViewClickListener;
        }


    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (null != mOnDismissListener) {
            mOnDismissListener.onDismiss(dialog);
        }
    }

    public void showDialog(FragmentManager fragmentManager) {
        String simpleName = this.getClass().getSimpleName();
        Fragment fragment = fragmentManager.findFragmentByTag(simpleName);
        if (fragment == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(this, simpleName);
            ft.commitAllowingStateLoss();
        }
    }

    public OnCommonDialogViewClickListener getOnViewClickListener() {
        return mOnViewClickListener;
    }

    /**
     * dp转px
     *
     * @param context context
     * @param dpValue dp
     * @return px
     */
    private int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static class Builder implements Serializable {
        private int mLayoutRes;
        private boolean mCancelableOutside;
        private DialogInterface.OnDismissListener mOnDismissListener;
        private OnCommonDialogBindViewListener mOnBindViewListener;
        public OnCommonDialogViewClickListener mOnViewClickListener;
        private int mWidth;
        private int mHeight;
        public int[] mIds;

        public Builder setLayoutRes(int res) {
            mLayoutRes = res;
            return this;
        }

        public Builder setCancelableOutside(boolean cancelableOutside) {
            cancelableOutside = cancelableOutside;
            return this;
        }

        public Builder setDismissListener(DialogInterface.OnDismissListener dismiss) {
            mOnDismissListener = dismiss;
            return this;
        }

        public Builder setBindViewListener(OnCommonDialogBindViewListener bindViewListener) {
            mOnBindViewListener = bindViewListener;
            return this;
        }

        public int getLayoutRes() {
            return mLayoutRes;
        }

        public OnCommonDialogViewClickListener getOnViewClickListener() {
            return mOnViewClickListener;
        }

        public OnCommonDialogBindViewListener getOnBindViewListener() {
            return mOnBindViewListener;
        }

        public boolean isCancelableOutside() {
            return mCancelableOutside;
        }

        public DialogInterface.OnDismissListener getOnDismissListener() {
            return mOnDismissListener;
        }

        public int[] getIds() {
            return mIds;
        }

        public int getWidth() {
            return mWidth;
        }

        public Builder setWidth(int width) {
            mWidth = width;
            return this;
        }

        public int getHeight() {
            return mHeight;
        }

        public Builder setHeight(int height) {
            mHeight = height;
            return this;
        }

        public Builder addOnClickListener(int... ids) {
            mIds = ids;
            return this;
        }

        public Builder setOnViewClickListener(OnCommonDialogViewClickListener listener) {
            mOnViewClickListener = listener;
            return this;
        }

        public void show(FragmentManager fragmentManager) {
            CommonDialog.newInstance(this).showDialog(fragmentManager);
        }
    }

}
