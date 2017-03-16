package com.example.administrator.mystudent.AsyncTaskLoadData;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mystudent.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class AsyncTaskLoadDataActivity extends Activity {
    private TextView textView;
    private String json;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_load_data);

        textView= (TextView) findViewById(R.id.textView);
        String URL = "http://www.imooc.com/api/teacher?type=4&num=30";
        new MyAsyncTaskTask().execute(URL);
       
    }

    class MyAsyncTaskTask extends AsyncTask {

        /**
         * @param params
         * @return 执行完之后的结果
         * 多线程执行方法
         */
        @Override
        protected String doInBackground(Object[] params) {
            URL url;
            InputStreamReader isr;
            String result="";
            String line;
            try {
                url = new URL((String) params[0]);
                InputStream is=url.openStream();
                isr=new InputStreamReader(is,"utf-8");
                BufferedReader br=new BufferedReader(isr);
                while((line=br.readLine())!=null){
                    result+=line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            json=result;
            return json;
        }

        /**
         * @param o 多线程执行完之后
         */
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            textView.setText((String)o);
        }
    }
}
