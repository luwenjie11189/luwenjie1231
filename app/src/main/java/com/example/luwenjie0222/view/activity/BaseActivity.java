package com.example.luwenjie0222.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Auther: 努力
 * @Date: 2019/2/22 14:28:${卢文杰}
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindView());
        initView();
        initData();
    }

    protected abstract int bindView();

    protected abstract void initView();

    protected abstract void initData();

}
