package com.example.administrator.mystudent.ButtonMove;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by hyang on 2017/3/9
 * email 390315032@qq.com.
 * 自定义的Button，并随着手指的移动而移动
 */

public class MoveButton extends Button {
    public MoveButton(Context context) {
        super(context);
    }

    public MoveButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoveButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {


            }
            break;
            case MotionEvent.ACTION_MOVE: {


            }
            break;
            case MotionEvent.ACTION_UP: {

            }
        }

        return true;
    }


    private void log(String s) {
        Log.e("MoveButtonTest", s);
    }
}
