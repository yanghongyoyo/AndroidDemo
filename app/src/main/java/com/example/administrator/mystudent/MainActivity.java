package com.example.administrator.mystudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.mystudent.AccessServer.AccessServiceActivity;
import com.example.administrator.mystudent.AsyncTaskLoadData.AsyncTaskLoadDataActivity;
import com.example.administrator.mystudent.ButtonMove.ButtonMoveActivity;
import com.example.administrator.mystudent.DownloadNotification.Main2Activity;
import com.example.administrator.mystudent.Egg.EggActivity;
import com.example.administrator.mystudent.ExpandableListView.ExpandableListViewActivity;
import com.example.administrator.mystudent.GetLocation.GetLocationActivity;
import com.example.administrator.mystudent.MoreClick.MoreClickActivity;
import com.example.administrator.mystudent.MyView.MyViewActivity;
import com.example.administrator.mystudent.Notification.NotificationActivity;
import com.example.administrator.mystudent.PropertyAnimation.PropertyAnimationActivity;
import com.example.administrator.mystudent.ShakeShake.ShakeActivity;
import com.example.administrator.mystudent.UIMould.UIMouldActivity;
import com.example.administrator.mystudent.VolleyTest.VolleyActivity;
import com.example.administrator.mystudent.WebView.WebViewActivity;
import com.example.administrator.mystudent.XUtils.TestUtilsActivity;
import com.example.administrator.mystudent.downloadManager.DownLoadActivity;
import com.example.administrator.mystudent.net.NetActivity;
import com.example.administrator.mystudent.surfaceView.TestSufaceViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private ListView myListView;
    private List mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMyListView();
    }
    private void setMyListView(){
        String [] s={"Android UI模板设计","AsyncTask异步加载数据","genymotion访问本地服务器","测试xutils","属性动画","volley的使用","WebView的使用","获取手机经纬度",
        "surfaceView的使用","Android多次点击事件","notification的使用","notification显示下载","摇一摇","网络操作","拿鸡蛋","downloadManager的使用","ExpandableListView的使用",
        "自绘view","按钮随手指的移动而移动"};
        mylist=new ArrayList();
        for(int i=0;i<s.length;i++) {
            Map map = new HashMap();
            map.put("title",(i+1)+"."+s[i]);
            mylist.add(map);
        }
        myListView= (ListView) findViewById(R.id.myList);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,mylist,R.layout.list_item,new String[]{"title"},new int[]{R.id.text});
        myListView.setAdapter(simpleAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        setIntent(UIMouldActivity.class);
                    }break;
                    case 1:{
                        setIntent(AsyncTaskLoadDataActivity.class);
                    }break;
                    case 2:{
                        setIntent(AccessServiceActivity.class);
                    }break;
                    case 3:{
                        setIntent(TestUtilsActivity.class);
                    }break;
                    case 4:{
                      setIntent(PropertyAnimationActivity.class);
                    }break;
                    case 5:{
                        setIntent(VolleyActivity.class);
                    }break;
                    case 6:{
                        setIntent(WebViewActivity.class);
                    }break;
                    case 7:{
                        setIntent(GetLocationActivity.class);
                    }break;
                    case 8:{
                        setIntent(TestSufaceViewActivity.class);
                    }break;
                    case 9:{
                        setIntent(MoreClickActivity.class);
                    }break;
                    case 10:{
                        setIntent(NotificationActivity.class);
                    }break;
                    case 11:{
                        setIntent(Main2Activity.class);
                    }break;
                    case 12:{
                        setIntent(ShakeActivity.class);
                    }break;
                    case 13:{
                        setIntent(NetActivity.class);
                    }break;
                    case 14:{
                        setIntent(EggActivity.class);
                    }break;
                    case 15:{
                        setIntent(DownLoadActivity.class);
                    }break;
                    case 16:{
                        setIntent(ExpandableListViewActivity.class);
                    }break;
                    case 17:{
                        setIntent(MyViewActivity.class);
                    }break;
                    case 18:{
                        setIntent(ButtonMoveActivity.class);
                    }break;

                }
            }
        });
    }

    private void setIntent(Class a){
        Intent intent=new Intent(MainActivity.this, a);
        startActivity(intent);
    }
}
