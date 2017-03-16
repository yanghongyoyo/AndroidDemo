package com.example.administrator.mystudent.AccessServer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.mystudent.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hyang on 2016/8/18.
 * genymotion访问自己的服务器
 */
public class AccessServiceActivity extends Activity {

    private static String url = "http://10.0.3.2/service/test.txt";
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_service);

        textView = (TextView) findViewById(R.id.textView);

        new mThread().start();

    }
    class mThread extends Thread{
        @Override
        public void run() {
            getInputStream();

            String s=streamToString(getInputStream());
            Log.i("info","得到的数据是："+s);
            textView.setText(s);
        }
    }

    public InputStream getInputStream() {
        try {
            URL u=new URL(url);
            HttpURLConnection conn= (HttpURLConnection) u.openConnection();
            InputStream is=conn.getInputStream();
           //InputStream is=u.openStream();
            return is;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String streamToString(InputStream inputStream) {
        InputStreamReader isr= null;
        try {
            isr = new InputStreamReader(inputStream,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedReader br=new BufferedReader(isr);
        String result="";
        String line;
        try {
            while ((line=br.readLine())!=null){
                result+=line;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
