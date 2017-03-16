package com.example.administrator.mystudent.PropertyAnimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.mystudent.R;

/**
 * Created by hyang on 2016/8/26.
 * 属性动画学习
 */
public class PropertyAnimationActivity extends android.app.Activity{
    private ImageView img;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        img= (ImageView) findViewById(R.id.iv_img);
        button= (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setAnimation1();
                //setAnimation2();
                //setAnimation3();
                setAnimation4();
            }
        });
    }

   /**
     * Tween动画
     */
    private void setAnimation1(){
        TranslateAnimation animation=new TranslateAnimation(0,200,0,0);
        animation.setDuration(3000);
        //animation.setFillAfter(true);//停留在动画完成的位置
        img.startAnimation(animation);
    }

    /**
     * 属性动画
     * 方式1
     */
    private void setAnimation2(){

        ObjectAnimator.ofFloat(img,"translationX",0,200f).setDuration(3000).start();
        ObjectAnimator.ofFloat(img,"rotation",0,360f).setDuration(3000).start();
    }

    /**
     * 属性动画
     * 方式2
     */
    private void setAnimation3(){

        PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("translationX",0,200f);
        PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("rotation",0,360f);
        ObjectAnimator.ofPropertyValuesHolder(img,p1,p2).setDuration(3000).start();
    }
    /**
     * 属性动画
     * 方式3
     * 有动画顺序
     */
    private void setAnimation4(){

        ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(img,"translationX",0,200f);
        ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(img,"rotation",0,360f);
        //创建android提供的几种动画效果（在Android的ＡＰＩｄｅｍｏ中）
        objectAnimator1.setInterpolator(new BounceInterpolator());

        AnimatorSet animatorSet=new AnimatorSet();
        //animatorSet.playSequentially(objectAnimator1,objectAnimator2);
        //按顺序播放动画
        animatorSet.play(objectAnimator1).after(objectAnimator2);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }
}
