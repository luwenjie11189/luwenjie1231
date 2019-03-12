package com.example.luwenjie0225.view.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luwenjie0225.R;
import com.example.luwenjie0225.application.Constant;
import com.example.luwenjie0225.model.bean.LoginBean;
import com.example.luwenjie0225.presenter.MainPresenter;
import com.example.luwenjie0225.presenter.SecondPresenter;
import com.example.luwenjie0225.view.interfaces.IMainView;

import java.util.HashMap;

public class SecondActivity extends BaseActivity implements IMainView<LoginBean> {

    private EditText phones;
    private EditText pwds;
    private Button register;
    private SecondPresenter secondPresenter;

    @Override
    protected int bindlayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
        phones = bindView(R.id.edit_phones);
        pwds = bindView(R.id.edit_pwds);
        register = bindView(R.id.button_register01);
    }

    @Override
    protected void initData() {
        secondPresenter = new SecondPresenter();
        secondPresenter.setView(this);
        register.setOnClickListener(new View.OnClickListener() {
            private HashMap<String, String> map;

            @Override
            public void onClick(View v) {
                map = new HashMap<>();
                map.put("pwd", pwds.getText().toString());
                map.put("phone", phones.getText().toString());
                secondPresenter.loadDataFromNet(Constant.Register, map);
            }
        });
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginBean.getMessage().equals("注册成功")) {
            Toast.makeText(this, "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onErr(String strmsg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        secondPresenter.ondetach();
    }


}
