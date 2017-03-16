package com.example.administrator.mystudent.DownloadNotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.administrator.mystudent.MainActivity;
import com.example.administrator.mystudent.R;

public class Main2Activity extends Activity {

    private Button mbutton;
    private NotificationManager notificationManage;
    private PendingIntent pendingIntent;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        notificationManage = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mbutton = (Button) findViewById(R.id.btn_downloaad);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startDownload();
                showProcessNotification();
                new downLoadTask().execute();
            }
        });
    }

    private void startDownload() {

        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

         notification = new Notification.Builder(this)
                .setTicker("开始下载")
                .setContentTitle("云联电话")
                .setContentText("正在下载")
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent)
                .build();
        notificationManage.notify(1, notification);
        Toast.makeText(getApplicationContext(), "开始下载！", Toast.LENGTH_SHORT).show();
    }

    private void showProcessNotification() {
        notification = new Notification(R.drawable.logo, "apk下载", System.currentTimeMillis());

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.notification_layout);
        notification.contentView = view;
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                R.string.app_name, new Intent(),
                PendingIntent.FLAG_UPDATE_CURRENT);
        notification.contentIntent = contentIntent;
    }

    /**
     * 36      *子线程，用来更新Notification
     * 37
     */
    class downLoadTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = 0; i <= 100; i++) {

                // 为了避免频繁发送消息所以每次增长10
                if (i % 10 == 0) {
                    try {
                        // 模拟耗时操作
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 更改文字
                    notification.contentView.setTextViewText(R.id.tv_notification, "已下载："+i
                            + "%");
                    // 更改进度条
                    notification.contentView.setProgressBar(R.id.pb_notification, 100,
                            i, false);
                    // 发送消息
                    notificationManage.notify(0, notification);
                }
            }
              return null;
        }
    }
}
