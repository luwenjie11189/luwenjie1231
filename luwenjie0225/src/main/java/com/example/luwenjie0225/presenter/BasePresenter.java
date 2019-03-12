package com.example.luwenjie0225.presenter;

import com.example.luwenjie0225.view.interfaces.IBaseView;

/**
 * @Auther: 努力
 * @Date: 2019/2/25 08:51:${卢文杰}
 * @Description:
 */
public class BasePresenter<V> implements IBaseView {

    private V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public void ondetach() {
        this.view = null;
    }

}
