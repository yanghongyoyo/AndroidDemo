package com.example.administrator.mystudent.ExpandableListView;

import android.app.ExpandableListActivity;
import android.os.Bundle;


public class ExpandableListViewActivity extends ExpandableListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("二级列表的使用");
        //设置适配器
        setListAdapter(new MyExpandableListAdapter(this));
    }
}
