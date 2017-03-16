package com.example.administrator.mystudent.UIMould;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mystudent.R;

/**
 * Created by hyang on 2016/8/16.
 */
public class TopBar extends RelativeLayout {
    /**
     * 标题栏的三个控件
     */
    private Button leftBtn, rightBtn;
    private TextView title;

    /**
     * 左边按钮的属性
     */
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    /**
     * 右边按钮的属性
     */
    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    /**
     * 中间TextView的属性
     */
    private int titleTextColor;
    private String titleText;
    private float titleTextSize;

    /**
     * 三个控件的布局参数
     */
    private LayoutParams leftParams, rightParams, titleParams;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.TopBar);

        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        leftText = ta.getString(R.styleable.TopBar_leftText);

        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        rightText = ta.getString(R.styleable.TopBar_rightText);

        titleText = ta.getString(R.styleable.TopBar_titleText);
        titleTextColor = ta.getColor(R.styleable.TopBar_titleColor, 0);
        titleTextSize = ta.getDimension(R.styleable.TopBar_titleSize, 0);


        //对ta进行回收
        ta.recycle();

        leftBtn = new Button(context);
        rightBtn = new Button(context);
        title = new TextView(context);

        /**
         * 设置属性
         */
        leftBtn.setText(leftText);
        leftBtn.setTextColor(leftTextColor);
        leftBtn.setBackground(leftBackground);

        rightBtn.setText(rightText);
        rightBtn.setTextColor(rightTextColor);
        rightBtn.setBackground(rightBackground);

        title.setText(titleText);
        title.setTextColor(titleTextColor);
        title.setTextSize(titleTextSize);
        title.setGravity(Gravity.CENTER);

        //设置整体背景颜色
        setBackgroundColor(0x7CFC0055);

        leftParams = new LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //添加控件
        addView(leftBtn, leftParams);

        rightParams = new LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightBtn, rightParams);

        titleParams = new LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(title, titleParams);

        leftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopBarListener.leftClick();
            }
        });
        rightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopBarListener.rightClick();
            }
        });
    }

    private OnTopBarListener onTopBarListener;

    public interface OnTopBarListener {
        void leftClick();

        void rightClick();
    }

    public void setOnTopBarListener(OnTopBarListener onTopBarListener) {

        this.onTopBarListener = onTopBarListener;
    }

}
