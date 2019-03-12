package com.example.luwenjie0225.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Auther: 努力
 * @Date: 2019/2/25 08:45:${卢文杰}
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindlayout());
        initView();
        initData();
    }

    protected abstract int bindlayout();

    protected abstract void initView();

    protected abstract void initData();

    protected <T extends View> T bindView(int resid) {
        return (T) findViewById(resid);
    }

}
