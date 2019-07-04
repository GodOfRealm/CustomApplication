package com.example.dev.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.widget.Toast;

import com.example.dev.base.BaseActivity;
import com.example.dev.myapplication.BR;
import com.example.dev.myapplication.R;
import com.example.dev.myapplication.databinding.ActivityDatabindingTestBinding;

import java.util.Random;

/**
 * Desc:
 * Author: zhangwenshun
 * Date: 2019/7/2
 * Company: @有门网络科技
 * Update Comments:
 */
public class DataBindingTestActivity extends BaseActivity {

    private Goods mGoods;
    ActivityDatabindingTestBinding binding;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_test);
    }

    @Override
    protected void initData() {
        mGoods = new Goods("code", "hi", 24);
        binding.setGoods(mGoods);
        binding.setGoodsHandler(new GoodsHandler());
    }

    @Override
    protected void initListener() {
    mGoods.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
        @Override
        public void onPropertyChanged(Observable sender, int propertyId) {
            if (propertyId == BR.details){
            }
        }
    });
    }

    public class GoodsHandler {

        public void changeGoodsName() {
            mGoods.setName("code" + new Random().nextInt(100));
            mGoods.setPrice(new Random().nextInt(100));
        }

        public void changeGoodsDetails() {
            mGoods.setDetails("hi" + new Random().nextInt(100));
            mGoods.setPrice(new Random().nextInt(100));
        }

    }
}
