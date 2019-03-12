package com.example.luwenjie0225.view.interfaces;


/**
 * @Auther: 努力
 * @Date: 2019/2/25 08:50:${卢文杰}
 * @Description:
 */
public interface IMainView<T> extends IBaseView {

    void onSuccess(T t);

    void onErr(String strmsg);

}
