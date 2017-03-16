package com.example.administrator.mystudent.ButtonMove;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mystudent.R;

public class ButtonMoveActivity extends Activity {

    private Button btn1;
    private int screenWidth;
    private int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_move);

        //DisplayMetrics取屏幕大小分辨率
        DisplayMetrics dm=getResources().getDisplayMetrics();
        screenWidth=dm.widthPixels;
        screenHeight=dm.heightPixels-50;

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnTouchListener(new MyOnTouchListener());

    }

    class MyOnTouchListener implements View.OnTouchListener {
        int lastX,lastY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int ea=event.getAction();
            Log.i("TAG", "Touch:"+ea);

            switch(ea){
                case MotionEvent.ACTION_DOWN:

                    lastX=(int)event.getRawX();//获取触摸事件触摸位置的原始X坐标
                    lastY=(int)event.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    int dx=(int)event.getRawX()-lastX;
                    int dy=(int)event.getRawY()-lastY;

                    int l=v.getLeft()+dx;
                    int b=v.getBottom()+dy;
                    int r=v.getRight()+dx;
                    int t=v.getTop()+dy;

                    //下面判断移动是否超出屏幕
                    if(l<0){
                        l=0;
                        r=l+v.getWidth();
                    }

                    if(t<0){
                        t=0;
                        b=t+v.getHeight();
                    }

                    if(r>screenWidth){
                        r=screenWidth;
                        l=r-v.getWidth();
                    }

                    if(b>screenHeight){
                        b=screenHeight;
                        t=b-v.getHeight();
                    }
                    v.layout(l, t, r, b);

                    lastX=(int)event.getRawX();
                    lastY=(int)event.getRawY();
                    Toast.makeText(getApplicationContext(),
                            "当前位置："+l+","+t+","+r+","+b,
                            Toast.LENGTH_SHORT).show();

                    //利用invalidate()刷新界面(加post多线程)
                    v.postInvalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    }

}
