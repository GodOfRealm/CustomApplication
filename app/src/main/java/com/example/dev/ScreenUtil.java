package com.example.dev;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.lang.reflect.Field;

public class ScreenUtil {

    private static ScreenUtil mInstance;

    private static float currentDensity = 0;

    private static float scaledDensity = 0;

    private static Object lock = new Object();

    private DisplayMetrics metrics = new DisplayMetrics();

    private int[] screenWH = {480, 960};

    private ScreenUtil(Context ctx) {
        loadSetting(ctx);
    }

    public static void recyle() {
        mInstance = null;
    }

    public static ScreenUtil getInstance(Context ctx) {
        synchronized (lock) {
            if (mInstance == null) {
                mInstance = new ScreenUtil(ctx);
            }
        }
        return mInstance;
    }

    private void loadSetting(Context ctx) {
        if (ctx == null) {
            return;
        }

        final WindowManager windowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        final Display display = windowManager.getDefaultDisplay();
        display.getMetrics(metrics);

        Point point = new Point();
        display.getSize(point);
        boolean isPortrait = point.x < point.y;
        final int width = isPortrait ? point.x : point.y;
        final int height = isPortrait ? point.y : point.x;

        metrics.widthPixels = width;
        metrics.heightPixels = height;

        screenWH[0] = width;
        screenWH[1] = height;
    }

    public DisplayMetrics getMetrics() {
        return metrics;
    }

    public float getDensity() {
        return metrics.density;
    }

    public int getDensityDpi() {
        return metrics.densityDpi;
    }

    public DisplayMetrics getDisplayMetrics() {
        return metrics;
    }

    public int[] getScreenWH() {
        return screenWH;
    }

    public static int getCurrentScreenWidth(Context context) {
        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.widthPixels;
    }

    public static int getCurrentScreenHeight(Context context) {
        int sdk = Build.VERSION.SDK_INT;

        DisplayMetrics metrics = getDisplayMetrics(context);
        if (sdk > 10 && sdk < 13) {
            return metrics.heightPixels - getStatusBarHeight(context);
        }
        return metrics.heightPixels;
    }

    public static int[] getCurrentScreenDime(Context context) {
        final int screenWidth = getCurrentScreenWidth(context);
        final int screenHeight = getCurrentScreenHeight(context);
        return new int[]{screenWidth, screenHeight};
    }

    /**
     * 返回屏幕尺寸
     *
     * @param context
     * @return
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int dip2px(Context context, float dipValue) {
        if (currentDensity > 0)
            return (int) (dipValue * currentDensity + 0.5f);

        currentDensity = getScreenDensity(context);
        return (int) (dipValue * currentDensity + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        if (scaledDensity > 0)
            return (int) (spValue * scaledDensity + 0.5f);

        scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scaledDensity + 0.5f);
    }

    public static int px2dip(Context ctx, float pxValue) {
        return (int) (pxValue / getScreenDensity(ctx) + 0.5f);
    }

    /**
     * This methode can be used to calculate the height and set it for views
     * with wrap_content as height. This should be done before
     * ExpandCollapseAnimation is created.
     *
     * @param context
     * @param view
     */
    public static void setHeightForWrapContent(Context context, View view) {
        int screenWidth = getCurrentScreenWidth(context);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(screenWidth, View.MeasureSpec.EXACTLY);

        view.measure(widthMeasureSpec, heightMeasureSpec);
        int height = view.getMeasuredHeight();
        view.getLayoutParams().height = height;
    }

    public static int getStatusBarHeight(Context context) {
        return getInternalDimenPixelSize(context, "status_bar_height");
    }

    public static int getStatusBarEdgeIgnore(Context context) {
        return getInternalDimenPixelSize(context, "status_bar_edge_ignore");
    }

    public static int getStatusBarHeightWay2(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private static int getInternalDimenPixelSize(Context context, String fieldName) {
        int result = 0;
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField(fieldName);
            result = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelSize(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getScreenInch(Context context) {
        double inch = getScreenInchDouble(context);
        return (int) Math.round(inch);
    }

    public static int getScreenInchClamped(Context context) {
        int result = getScreenInch(context);
        if (result < 6) {
            result = 6;
        } else if (result > 10) {
            result = 10;
        }
        return result;
    }

    public static double getScreenInchDouble(Context context) {
        DisplayMetrics dm = getDisplayMetrics(context);
        double diagonalPixels = Math.sqrt(Math.pow(dm.widthPixels, 2) + Math.pow(dm.heightPixels, 2));
        double screenSize = diagonalPixels / (160 * dm.density);
        return screenSize;
    }

    /**
     * 判断当前设备是手机还是平板，代码来自 Google I/O App for Android
     *
     * @param ctx
     * @return 平板返回 True，手机返回 False
     */
    public static boolean isTablet(Context ctx) {
        return (ctx.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


}
