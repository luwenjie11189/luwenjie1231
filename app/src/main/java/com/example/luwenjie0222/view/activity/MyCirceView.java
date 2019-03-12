package com.example.luwenjie0222.view.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Auther: 努力
 * @Date: 2019/2/22 14:36:${卢文杰}
 * @Description:
 */
public class MyCirceView extends View {

    private int measuredWidth;
    private int measuredHeight;

    public MyCirceView(Context context) {
        super(context);
    }

    public MyCirceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawCircle(measuredWidth/2,measuredHeight/2,100,paint);
    }

}
