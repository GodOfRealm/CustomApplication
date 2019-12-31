package com.example.basemodule.net.common;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxUtil {

    /**
     * @param activity    Activity
     * @param showLoading 是否显示Loading
     * @return 转换后的ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper(final RxAppCompatActivity activity, final boolean showLoading) {
        if (activity == null) return rxSchedulerHelper();
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                Observable<T> compose = (Observable<T>) observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(activity.bindUntilEvent(ActivityEvent.DESTROY));
                if (showLoading) {
                    return (ObservableSource<T>) compose.compose(ProgressUtils.applyProgressBar(activity));
                } else {
                    return compose;
                }
            }
        };
    }


    /**
     * @param fragment    fragment
     * @param showLoading 是否显示Loading
     * @return 转换后的ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper(final RxFragment fragment, final boolean showLoading) {
        if (fragment == null || fragment.getActivity() == null) return rxSchedulerHelper();
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                Observable<T> compose = (Observable<T>) observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(fragment.bindUntilEvent(FragmentEvent.DESTROY));
                if (showLoading) {
                    return (ObservableSource<T>) compose.compose(ProgressUtils.applyProgressBar(fragment.getActivity()));
                } else {
                    return compose;
                }
            }
        };
    }


    /**
     * 统一线程处理
     * @return 转换后的ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}