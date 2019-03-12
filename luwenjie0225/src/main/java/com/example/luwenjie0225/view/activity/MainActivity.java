package com.example.luwenjie0225.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luwenjie0225.R;
import com.example.luwenjie0225.application.Constant;
import com.example.luwenjie0225.model.bean.LoginBean;
import com.example.luwenjie0225.presenter.MainPresenter;
import com.example.luwenjie0225.view.interfaces.IMainView;

import java.util.HashMap;

public class MainActivity extends BaseActivity implements IMainView<LoginBean> {

    private EditText phone;
    private EditText pwd;
    private Button login;
    private Button register;
    private MainPresenter mainPresenter;

    @Override
    protected int bindlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        phone = findViewById(R.id.edit_phone);
        pwd = findViewById(R.id.edit_pwd);
        login = findViewById(R.id.button_login);
        register = findViewById(R.id.button_register);

    }

    @Override
    protected void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        login.setOnClickListener(new View.OnClickListener() {
            private HashMap<String, String> map;

            @Override
            public void onClick(View v) {
                map = new HashMap<>();
                map.put("pwd", pwd.getText().toString());
                map.put("phone", phone.getText().toString());
                mainPresenter.loadDataFromNet(Constant.Login, map);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginBean.getMessage().equals("登录成功")) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onErr(String strmsg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.ondetach();
    }
}
