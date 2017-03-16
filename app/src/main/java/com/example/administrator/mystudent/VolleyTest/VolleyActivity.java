package com.example.administrator.mystudent.VolleyTest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.mystudent.R;

public class VolleyActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private String URL="http://www.baidu.com";
    private String URL1="http://n.sinaimg.cn/news/transform/20160906/vjNn-fxvqcts9594529.jpg";
    private TextView mTextView;
    private ImageView mImageView;
    private String TAG="Volley";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_volley);
        //初始化volley
        mRequestQueue= Volley.newRequestQueue(this);
        mTextView= (TextView) findViewById(R.id.textVolley);
        mImageView= (ImageView) findViewById(R.id.imgVolley);
        getVolleyString();
        getVolleyImg();

    }

    /**
     * volley请求数据
     */
    private void getVolleyString(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            //请求成功的时候处理方法
            public void onResponse(String s) {
                mTextView.setText(s);
                Log.i(TAG,"volley请求处理成功！");

            }
        }, new Response.ErrorListener() {
            @Override
            //请求失败的时候处理方法
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG,"请求处理失败");
            }
        });
        //把请求加入到队列中去
        mRequestQueue.add(stringRequest);
        //设置标签，识别每个请求
        stringRequest.setTag("A");
    }

    /**
     * volley请求图片
     */
    private void getVolleyImg(){

        ImageRequest imgRequest=new ImageRequest(URL1, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap arg0) {

                mImageView.setImageBitmap(arg0);
            }
        }, 600, 400, Bitmap.Config.ARGB_8888, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError arg0) {
                Toast.makeText(getApplicationContext(),"请求图片失败！！！",Toast.LENGTH_SHORT).show();

            }
        });
        mRequestQueue.add(imgRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //根据设置的标签，终止请求
        //mRequestQueue.cancelAll("A");
        Log.i(TAG,"终止请求成功！");
        //终止所有请求
        mRequestQueue.cancelAll(this);
    }

}
