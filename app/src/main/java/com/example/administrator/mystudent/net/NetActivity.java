package com.example.administrator.mystudent.net;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.mystudent.R;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.xutils.common.util.IOUtil.copy;

/**
 * Created by hyang on 2017/1/10
 * email 390315032@qq.com.
 * 网络操作学习
 */

public class NetActivity extends Activity {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        initView();
    }

    private void initView() {
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new MyClickListener());
        btn2.setOnClickListener(new MyClickListener());
        btn3.setOnClickListener(new MyClickListener());

        img1= (ImageView) findViewById(R.id.img1);
        img2= (ImageView) findViewById(R.id.img2);
        img3= (ImageView) findViewById(R.id.img3);
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:
                   //执行多线程
                    MyAsync myAsync=new MyAsync();
                    myAsync.execute();
                    break;
                case R.id.btn2:
                    img2.setBackgroundResource(R.drawable.img1);
                    break;
                case R.id.btn3:
                    break;
                default:break;
            }
        }
    }


    /**
     * 使用HttpURLConnection下载图片
     */
    public InputStream HttpURLConnectionTest(){
        InputStream is=null;
        try {
            //创建url
            URL url=new URL("http://img2.xinjunshi.com/uploads/allimg/170110/136-1F110095240.jpg");
            //创建HttpURlConnection对象
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            //设置请求方式
            conn.setRequestMethod("GET");
            //设置超时
            conn.setConnectTimeout(5000);
            //对响应码进行判读
            if(conn.getResponseCode()==200){
                Log.e(getClass().toString(),"请求数据成功！");
                //处理获取的到的流
                is=conn.getInputStream();
                return is;

            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(getClass().toString(),"网络数据错误!"+e.toString());
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(getClass().toString(),"IO流关闭异常!"+e.toString());
            }
        }

        return null;
    }

    protected class MyAsync extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {
            //多线程执行网络操作（网络操作禁止在主线程中进行）
           InputStream is=HttpURLConnectionTest();
            //执行完之后可以返回值
            return is;
        }

        @Override
        protected void onPostExecute(Object o) {
            InputStream is= (InputStream) o;
            //把io流转化为字节数组
            Bitmap bitmap = null;
            BufferedOutputStream out = null;
            try
            {
                final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
                out = new BufferedOutputStream(dataStream);
                copy(is, out);
                out.flush();
                byte[] data = dataStream.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                data = null;
                img1.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();

            }

        }
    }
}
