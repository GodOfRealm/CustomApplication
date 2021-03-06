package com.example.testmodule

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonmodule.Navigator
import kotlinx.android.synthetic.main.activity_main_module.*

@Route(path = "/module/activity")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_module)
        test_max.setOnClickListener {
            //            ARouter.getInstance().build("/max/activity").navigation()
            Navigator.instance.getCommonNavigator().openWeb("https://www.cnblogs.com/android-deli/p/10310633.html")
        }
    }
}
