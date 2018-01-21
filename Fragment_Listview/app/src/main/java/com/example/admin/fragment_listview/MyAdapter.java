package com.example.admin.fragment_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 18/02/2016.
 */
public class MyAdapter extends BaseAdapter {
    ArrayList<People_Enity> arrayList=new ArrayList<>();
    public void setArraylist(ArrayList<People_Enity> people_enityArrayList){
        arrayList=people_enityArrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        convertView=inflater.inflate(R.layout.item_lisiview,null);

        TextView tv_name=(TextView)convertView.findViewById(R.id.tv_name);
        TextView tv_age=(TextView)convertView.findViewById(R.id.tv_age);
        TextView tv_adress=(TextView)convertView.findViewById(R.id.tv_adress);

        People_Enity people_enity=arrayList.get(position);
        tv_name.setText("Name "+people_enity.getName().toString());
        tv_age.setText("Ages: "+people_enity.getAges());
        tv_adress.setText("Adress: "+people_enity.getAdress().toString());

        return convertView;
    }
}
