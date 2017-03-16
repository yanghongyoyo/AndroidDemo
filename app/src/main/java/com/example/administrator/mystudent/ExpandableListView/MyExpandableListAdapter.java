package com.example.administrator.mystudent.ExpandableListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyang on 2017/3/1
 * email 390315032@qq.com.
 * 可收缩列表适配器
 */

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private String [] group={"衣服","食品","水果"};
    private String [] cloths={"衬衫","西裤","内衣"};
    private String [] food={"面包","蛋糕","可乐","橙汁"};
    private String [] fruits={"苹果","香蕉","草莓"};

    private List<String> groupList = null;
    private List<List<String>> itemList = null;

    protected MyExpandableListAdapter(Context context){
        this.context=context;
        groupList=new ArrayList<String>();
        itemList=new ArrayList<List<String>>();

        setListData();
    }

    /**
     * 向list中添加数据
     */
    private void setListData() {
        for(String s:group){
            groupList.add(s);
        }
        List clothsList=new ArrayList();
        List foodList=new ArrayList();
        List fruitsList=new ArrayList();

        for(String s:cloths){
            clothsList.add(s);
        }
        for(String s:food){
            foodList.add(s);
        }
        for(String s:fruits){
            fruitsList.add(s);
        }

        itemList.add(clothsList);
        itemList.add(foodList);
        itemList.add(fruitsList);
    }

    @Override
    public int getGroupCount() {
        //返回组数量
        return itemList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //返回当前组的节点数量
        return itemList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //返回分组对象，用于一些数据传递，在事件处理时可直接取得和分组相关的数据
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //设置子节点数据
        return itemList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //设置组显示View，这里可是设置布局文件引用
        TextView view=null;
        if(convertView==null){
            view=new TextView(context);
        }else{
            view= (TextView) convertView;
        }
        //设置textView的显示样式
        view.setTextSize(30);
        view.setPadding(50,5,0,5);
        //向textView设置数据
        String s=groupList.get(groupPosition);
        view.setText(s);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //设置节点显示View，这里可是设置布局文件引用
        TextView view=null;
        if(convertView==null){
            view=new TextView(context);
        }else{
            view= (TextView) convertView;
        }
        view.setTextSize(20);
        view.setPadding(30,5,0,5);
        //向textView设置数据
        String s=itemList.get(groupPosition).get(childPosition);
        view.setText(s);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
