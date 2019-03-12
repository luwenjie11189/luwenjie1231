package com.example.luwenjie0225.presenter;

import com.example.luwenjie0225.application.Constant;
import com.example.luwenjie0225.model.bean.LoginBean;
import com.example.luwenjie0225.model.util.HttpUtils;
import com.example.luwenjie0225.view.interfaces.IMainView;

import java.util.HashMap;

/**
 * @Auther: 努力
 * @Date: 2019/2/25 08:52:${卢文杰}
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView<LoginBean>> {

    private final HttpUtils httpUtils;

    public MainPresenter() {
        httpUtils = HttpUtils.getInstance();
    }

    public void loadDataFromNet(final String login, HashMap<String, String> map) {
        httpUtils.postData(login, LoginBean.class, map, new HttpUtils.CallBackData<LoginBean>() {
            @Override
            public void onResponse(LoginBean loginBean) {
                if (loginBean != null) {
                    getView().onSuccess(loginBean);
                }
            }

            @Override
            public void onFail(String err) {
                getView().onErr(err);
            }
        });
    }
}
