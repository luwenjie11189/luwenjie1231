package com.example.luwenjie0222.view.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

import com.example.luwenjie0222.R;

/**
 * @Auther: 努力
 * @Date: 2019/2/22 14:28:${卢文杰}
 * @Description:
 */
public class MyPresenActivity extends BaseActivity {

    private MyCirceView myCirceView;

    @Override
    protected int bindView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        myCirceView = findViewById(R.id.circeView);
    }

    @Override
    protected void initData() {
        myCirceView.getScaleX();
        myCirceView.getRotationX();
        myCirceView.getRotation();
        //myCirceView.getS
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator translationX = ObjectAnimator.ofFloat(myCirceView, "translationX", 0, 1000);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(myCirceView, "translationY", 0, 1000,0,1000,0);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(myCirceView, "scaleX", 1, 3,0,3,1);
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(myCirceView, "rotation", 0, 360);
//      translationX.setDuration(3000);
//      translationX.start();
//      rotationX.setRepeatCount(-1);
//      ranslationX.setDuration(3000);
//      animatorSet.play(translationX).with(rotationX);
//      animatorSet.setDuration(3000);
//      animatorSet.start();
//      test();
//        rotationX.setDuration(3000);
//        rotationX.start();
    }
}
