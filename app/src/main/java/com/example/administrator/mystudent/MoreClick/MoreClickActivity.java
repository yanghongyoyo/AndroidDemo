package com.example.administrator.mystudent.MoreClick;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mystudent.R;

public class MoreClickActivity extends AppCompatActivity {
    private TextView tv_name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_click);

        tv_name= (TextView) findViewById(R.id.tv_name);
        tv_name.setOnClickListener(new View.OnClickListener()
        {
            //需要监听几次点击事件数组的长度就为几
            //如果要监听双击事件则数组长度为2，如果要监听3次连续点击事件则数组长度为3...
            long[] mHints = new long[3];//初始全部为0
            @Override
            public void onClick(View v)
            {
                //将mHints数组内的所有元素左移一个位置
                System.arraycopy(mHints, 1, mHints, 0, mHints.length - 1);
                //获得当前系统已经启动的时间
                mHints[mHints.length - 1] = SystemClock.uptimeMillis();
                if(SystemClock.uptimeMillis()-mHints[0]<=500)
                Toast.makeText(getApplicationContext(),"当你点击三次之后才会出现", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
