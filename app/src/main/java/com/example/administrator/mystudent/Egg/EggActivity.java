package com.example.administrator.mystudent.Egg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.mystudent.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 求答案
 * 一筐鸡蛋：
 * 1个1个拿，正好拿完。
 * 2个2个拿，还剩1个。
 * 3个3个拿，正好拿完。
 * 4个4个拿，还剩1个。
 * 5个5个拿，还差1个。
 * 6个6个拿，还剩3个。
 * 7个7个拿，正好拿完。
 * 8个8个拿，还剩1个。
 * 9个9个拿，正好拿完。
 * <p>
 * 问筐里最少有多少鸡蛋？
 */
public class EggActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

        textView = (TextView) findViewById(R.id.eggNumber);

        textView.setText("这里面的值是多少");

        //eggNumber();
        //maopaoSoft();
        //fastLook();
        testIterator();
    }

    /**
     * 复习迭代器的使用
     */
    private void testIterator() {
        List list=new ArrayList();
        for(int i=0;i<5;i++){
            list.add("第"+i+"项");
        }
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            String s= (String) iterator.next();
            Log.e("打印的值",s);
        }

    }

    /**
     * 写一个快速查找算法，找出数组中相同的两个数
     */
    private void fastLook() {
        int a[]={12,34,67,43,26,7,89,43};
        //Boolean res=false;  //res表示是否查找到相同数
        int x=0;
        for(int i=0;i<a.length;i++){
            x=a[i];
            for(int j=i+1;j<a.length;j++){
                if(a[j]==x){
                    x=a[j];
                    Log.e("相同数是：",x+"");
                }
            }
        }

    }

    /**
     *写一个简单的冒泡排序
     */
    private void maopaoSoft() {
        int [] a={34,12,45,99,11,8,64};
        int temp=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }

        for(int x:a){
            Log.e("按顺序输出排序：",x+"");
        }
    }

    /**
     * 计算有多少个鸡蛋
     */
    private void eggNumber() {
        int y = 0;//存放计算的结果
        for (int i = 0; i < 40; i++) {
            int x = 7 * 9 * i; //假设数为x
            //对20个数进行求余判断
            if (x % 2 == 1) {
                if (x % 4 == 1) {
                    if ((x + 1) % 5 == 0) {
                        if (x % 6 == 3) {
                            if (x % 8 == 1) {
                                y = x;
                            }
                        }
                    }
                }
            }
        }
        Log.e("计算结果", "Y的值是：" + y);
        textView.setText("计算的结果是：" + y);
    }
}
