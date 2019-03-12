package com.example.luwenjie02111.presenter;

import android.util.Log;

import com.example.luwenjie02111.application.Constant;
import com.example.luwenjie02111.model.bean.NewsBean;
import com.example.luwenjie02111.model.utils.HttpUtils;
import com.example.luwenjie02111.view.interfaces.IMainView;

/**
 * @Auther: 努力
 * @Date: 2019/2/23 14:55:${卢文杰}
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView<NewsBean>> {

    private final HttpUtils httpUtils;

    public MainPresenter() {
        httpUtils = HttpUtils.getInstance();
    }

    public void loadDataFromNet(int page) {
        httpUtils.getData(Constant.BASE_URL + page, NewsBean.class, new HttpUtils.CallbackData<NewsBean>() {
            @Override
            public void onResponse(NewsBean newsBean) {
                if(getView()!=null){
                    getView().onSuccess(newsBean);
                }else{
                    Log.e("myMessage","哥们你的 view 没有绑定");
                }

            }

            @Override
            public void onFail(String err) {

                getView().onErr(err);
            }
        });
    }
}
