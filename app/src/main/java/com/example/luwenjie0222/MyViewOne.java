package com.example.luwenjie0222;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @Auther: 努力
 * @Date: 2019/2/22 08:41:${卢文杰}
 * @Description:
 */
public class MyViewOne extends ViewGroup {
    public MyViewOne(Context context) {
        this(context, null);
    }

    public MyViewOne(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
    }




    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
