package com.example.admin.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Admin on 30/12/2015.
 */

public class myAdapter extends BaseAdapter {
    ArrayList<FoodEnity> mfood;


    public void setListFood( ArrayList<FoodEnity> food) {
        mfood = food;
    }

    @Override
    public int getCount() {
        return mfood.size();
    }

    @Override
    public Object getItem(int position) {
        return mfood.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //b1: laays layout cho item list view
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.layout_food,null,false);

         //b2: laays mons anw owr vij tris postion
        FoodEnity food=(FoodEnity) getItem(position);
        //b3:hiển thị thông tin
        ImageView img_icon=(ImageView) convertView.findViewById(R.id.img_food);
        img_icon.setImageResource(food.getIcon());

        TextView name=(TextView) convertView.findViewById(R.id.tv_foodName);
        name.setText(food.getName().toString());

        TextView nameRes=(TextView) convertView.findViewById(R.id.tv_restaurantName);
        nameRes.setText(food.getResName().toString());

        TextView cost =(TextView)convertView.findViewById(R.id.tv_cost);
        cost.setText("$"+food.getCost());


        return convertView;
    }
}
