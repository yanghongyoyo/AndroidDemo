package com.example.administrator.mystudent.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hyang on 2017/3/8
 * email 390315032@qq.com.
 * 自定义view
 */

public class MyView extends View implements View.OnClickListener{

      // 定义画笔
      private Paint mPaint;
     // 用于获取文字的宽和高
     private Rect mRect;
    // 计数值，每点击一次本控件，其值增加1
     private int mCount;

    public MyView(Context context) {
        this(context,null,0);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect=new Rect();
        setOnClickListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.parseColor("#7ab900"));//设置画笔为绿色
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);//在画布上化一个蓝色矩形
        mPaint.setColor(Color.parseColor("#ff2525"));//将画笔设置为白色
        mPaint.setTextSize(30);//设置画笔大小

        String s=String.valueOf(mCount);//int转化为字符串
        //获取文字的宽和高
        mPaint.getTextBounds(s,0,s.length(),mRect);
        float textWidth = mRect.width();
        float textHeight = mRect.height();

        //绘制字符串
        canvas.drawText(s, getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 2, mPaint);

    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();//重绘
    }
}
