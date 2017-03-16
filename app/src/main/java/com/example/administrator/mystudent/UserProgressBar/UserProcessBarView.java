package com.example.administrator.mystudent.UserProgressBar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.example.administrator.mystudent.R;

/**
 * Created by Administrator on 2016/9/19.
 *
 */
public class UserProcessBarView extends ProgressBar {

    private int mTextSize=10;
    private int mTextColor=0xfffc00d1;
    private int mUnReachColor=0xffd3d6da;
    private int mUnReachHight=2;
    private int mReachColor=0xffd3d6da;
    private int mReachHight=2;
    private int mTextOffset=10;

    private Paint mPaint=new Paint();
    private int mRealWidth;

    public UserProcessBarView(Context context) {
        this(context, null);
    }

    public UserProcessBarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UserProcessBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        obtainStyledAttrs(attrs);
    }

    private void obtainStyledAttrs(AttributeSet attrs) {
        TypedArray ta=getContext().obtainStyledAttributes(attrs, R.styleable.UserProcessBarView);

        mTextSize= (int) ta.getDimension(R.styleable.UserProcessBarView_progress_text_size,mTextSize);
        mTextColor=ta.getColor(R.styleable.UserProcessBarView_progress_text_color,mTextColor);
        mUnReachColor=ta.getColor(R.styleable.UserProcessBarView_progress_unreach_color,mUnReachColor);
        mUnReachHight= (int) ta.getDimension(R.styleable.UserProcessBarView_progress_unreach_height,mUnReachHight);
        mReachColor=ta.getColor(R.styleable.UserProcessBarView_progress_reach_color,mReachColor);
        mReachHight= (int) ta.getDimension(R.styleable.UserProcessBarView_progress_reach_height,mReachHight);
        mTextOffset= (int) ta.getDimension(R.styleable.UserProcessBarView_progress_text_offset,mTextOffset);

        ta.recycle();
    }
}
