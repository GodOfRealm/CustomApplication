package com.example.dev.delegate;

import com.miguan.pick.core.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019-08-31
 * Company: @有门网络科技
 * Update Comments:
 */
public class BaseDelegate {
    private List<BasePresenter> presenterList = new ArrayList();

    public void detachView() {
        for (BasePresenter presenter : presenterList) {
            if (presenter != null) {
                presenter.detachView();
            }
        }
    }

    public void addPresenter(BasePresenter presenter) {
        presenterList.add(presenter);
    }
}
