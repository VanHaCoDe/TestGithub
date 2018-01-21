package com.example.admin.comitplusle_van_habai_kiem_tra;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 13/01/2016.
 */

public class MyAdapter extends BaseAdapter {


    ArrayList<Products_Enity> products = new ArrayList<Products_Enity>();

    public void setArrayList(ArrayList<Products_Enity> arrayList) {
        products = arrayList;
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.item_listview, null);

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_description = (TextView) convertView.findViewById(R.id.tv_description);
        TextView tv_price = (TextView) convertView.findViewById(R.id.tv_price);


        Products_Enity products_enity = (Products_Enity) getItem(position);
        tv_name.setText(products_enity.getName().toString());
        tv_description.setText(products_enity.getDescription().toString());
        tv_price.setText(String.valueOf(products_enity.getPrice()));

        return convertView;
    }
}
