package com.example.administrator.mystudent;

import android.app.Application;
import android.util.Log;

import org.xutils.x;

/**
 * Created by hyang on 2016/8/23.
 */
public class MyApplication extends Application {
    private static final String TAG ="Global" ;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xUtils
        x.Ext.init(this);
        //输出调试信息
        x.Ext.setDebug(true);
        getAnyException();
    }

    /**
     * 捕获全局的任意异常
     */
    private void getAnyException() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                ex.printStackTrace();
                Log.e(TAG,"捕获到异常"+ex.toString());
                //1.把捕获到的异常存储到本地文件中
                //2.处理把异常文件上传到服务器
                //3.正常退出App(避免出现弹出对话框强制退出)
                System.exit(0);
            }
        });
    }
}
