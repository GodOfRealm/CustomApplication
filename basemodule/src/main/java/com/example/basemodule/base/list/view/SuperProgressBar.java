package com.example.basemodule.base.list.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.example.testmodule.R;


/**
 * 适配android6.0以上的ProgressBar
 * Created by li on 2016/6/23.
 */
public class SuperProgressBar extends ProgressBar {
    public SuperProgressBar(Context context) {
        super(context);
        init();
    }

    public SuperProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SuperProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Drawable drawable = getResources().getDrawable(R.drawable.progress_smart_loading);
            drawable.setBounds(0,0,getResources().getDimensionPixelSize(R.dimen.bdp_24),getResources().getDimensionPixelSize(R.dimen.bdp_24));
            setIndeterminate(true);
            setIndeterminateDrawable(drawable);
        }/*else {
            Drawable drawable = getResources().getDrawable(R.drawable.progress_loading);
            drawable.setBounds(0,0,getResources().getDimensionPixelSize(R.dimen.bdp_30),getResources().getDimensionPixelSize(R.dimen.bdp_30));
            setIndeterminateDrawable(drawable);
        }*/
    }
}
