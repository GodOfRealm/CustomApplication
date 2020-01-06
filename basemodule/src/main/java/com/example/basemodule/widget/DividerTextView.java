package com.example.basemodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.blankj.utilcode.util.SizeUtils;
import com.example.testmodule.R;


/**
 * Desc:带分割线的TextView
 * Author: zhangwenshun
 * Date: 2019/5/20
 * Company: @有门网络科技
 * Update Comments:
 */
public class DividerTextView extends android.support.v7.widget.AppCompatTextView {

    private float mDp2px;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mMarginStart;
    private int mMarginEnd;
    private int mOriginHeight;
    private int mOriginBottom;

    private boolean mDividable = true;

    public DividerTextView(Context context) {
        this(context, null);
    }

    public DividerTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DividerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DividerTextView);
        mDp2px = typedArray.getDimension(R.styleable.DividerTextView_dividerHeight, isInEditMode
                () ? 2 : SizeUtils.dp2px(0.5f));
        mMarginStart = (int) typedArray.getDimension(R.styleable
                .DividerTextView_dividerMarginStart, isInEditMode() ? 34 : SizeUtils.dp2px(17f));
        mMarginEnd = (int) typedArray.getDimension(R.styleable
                .DividerTextView_dividerMarginEnd, isInEditMode() ? 34 :  SizeUtils.dp2px(0f));
        int dividerColor = typedArray.getColor(R.styleable.DividerTextView_dividerTextViewColor,
                ContextCompat.getColor(context, R.color.divPrimary));
        typedArray.recycle();

        mPaint.setColor(dividerColor);
    }

    public void setDividable(boolean enable) {
        mDividable = enable;
        requestLayout();
    }

    public void setDividerMarginStart(int marginStart) {
        mMarginStart = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP
                , marginStart, getContext().getResources().getDisplayMetrics());
        invalidate();
    }
    public void setDividerMarginEnd(int marginEnd) {
        mMarginEnd = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP
                , marginEnd, getContext().getResources().getDisplayMetrics());
        invalidate();
    }
    public void setDividerHeight(float height) {
        mDp2px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP
                , height, getContext().getResources().getDisplayMetrics());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mOriginHeight == 0) {
            mOriginHeight = getMeasuredHeight();
            mOriginBottom = getPaddingBottom();
        }
        setMeasuredDimension(widthMeasureSpec, mDividable ? (int) (mOriginHeight + mDp2px) : mOriginHeight);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), (int) (mOriginBottom + mDp2px));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mDividable) {
            canvas.drawRect(mMarginStart, getMeasuredHeight() - mDp2px, getWidth()-mMarginEnd, getMeasuredHeight(), mPaint);
        }
    }
}
