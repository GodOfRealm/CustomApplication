package com.example.dev.mvpTest.lifecycleMvPtest;


/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-31
 * Company: @有门网络科技
 * Update Comments:
 */
public class LifeTestContract {
    interface Model {
        String login(String username, String password);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(String test);
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void login(String username, String password);
    }
}
