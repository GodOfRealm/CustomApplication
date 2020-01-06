package com.example.basemodule

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.basemodule.base.BaseActivity
import com.example.basemodule.net.common.ResponseObserver
import com.example.basemodule.net.common.RxUtil
import com.example.basemodule.test.ArticleWrapper
import com.example.basemodule.test.LoginResponse
import com.example.basemodule.test.RetrofitHelper
import kotlinx.android.synthetic.main.activity_base_main.*
import java.util.HashMap

@Route(path = "/base/activity")
class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_base_main
    }

    override fun init(savedInstanceState: Bundle?) {
        login.setOnClickListener {
            RetrofitHelper.getApiService()
                    .login(getParameters())
                    .compose(RxUtil.rxSchedulerHelper(this, false))
                    .subscribe(object : ResponseObserver<LoginResponse>() {
                        override fun onSuccess(response: LoginResponse) {
                            showToast("登录成功")
                        }
                    })
        }
        btn.setOnClickListener {
            RetrofitHelper.getApiService()
                    .article
                    .compose(RxUtil.rxSchedulerHelper(this, true))
                    .subscribe(object : ResponseObserver<ArticleWrapper>() {
                        override fun onSuccess(response: ArticleWrapper) {
                            showToast("Request Success，size is：" + response.getDatas()?.size)
                        }
                    })
        }
    }

    private fun getParameters(): Map<String, Any> {
        val map = HashMap<String, Any>()
        map["username"] = "110120"
        map["password"] = "123456"
        return map
    }
}
