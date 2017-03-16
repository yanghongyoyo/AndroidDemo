package com.example.administrator.mystudent.Notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mystudent.MainActivity;
import com.example.administrator.mystudent.R;

/**
 * Created by Administrator on 2016/9/21.
 *
 */
public class NotificationActivity extends Activity{

    private static final int NOTIFICATION_FLAG = 1;
    private Button mButton;
    NotificationManager manager;
    PendingIntent pendingIntent3;
    Notification notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notification);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mButton= (Button) findViewById(R.id.mButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
  }

    private void showNotification() {
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。

        pendingIntent3 = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);
        // 通过Notification.Builder来创建通知，注意API Level
        // API16之后才支持

        notify = new Notification.Builder(this)
                .setSmallIcon(R.drawable.img2)
                .setTicker("TickerText:" + "您有新短消息，请注意查收！")
                .setContentTitle("新消息")
                .setContentText("你现在在哪里啊！！！")
                .setContentIntent(pendingIntent3).setNumber(1).build();
        // level16及之后增加的，API11可以使用getNotificatin()来替代
        notify.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
        manager.notify(NOTIFICATION_FLAG, notify);//通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
    }

}
