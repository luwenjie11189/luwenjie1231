package com.example.luwenjie02111.view.interfaces;

/**
 * @Auther: 努力
 * @Date: 2019/2/23 14:55:${卢文杰}
 * @Description:
 */
public interface IMainView<T> extends IBaseView {
    void onSuccess(T t);

    void onErr(String errmsg);
}
