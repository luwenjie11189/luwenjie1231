package com.example.luwenjie02111.presenter;

import com.example.luwenjie02111.view.interfaces.IBaseView;

/**
 * @Auther: 努力
 * @Date: 2019/2/23 14:55:${卢文杰}
 * @Description:
 */
public class BasePresenter<V extends IBaseView> {

    private V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }
}
