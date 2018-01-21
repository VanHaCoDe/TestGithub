package com.example.admin.listview_2type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 06/01/2016.
 */
public class MyAdapter extends BaseAdapter {
    private static class MyViewHolder {
        TextView tv_name, tv_price;
        RatingBar ratingBar;
        EditText et_qlty;
    }

    ArrayList<FoodEntity> mFoods;

    public void setArrayList(ArrayList<FoodEntity> food) {
        mFoods = food;
    }

    @Override
    public int getCount() {

        return mFoods.size();
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        int r=position%2;
//        if (r==0){
//            convertView=inflater.inflate(R.layout.item_type_1,null);
//        }else {
//            convertView=inflater.inflate(R.layout.item_type_2,null);
//        }
        MyViewHolder myViewHolder = new MyViewHolder();

        if(convertView==null){
            convertView=inflater.inflate(R.layout.item_listview,null);
            myViewHolder=new MyViewHolder();
            myViewHolder.tv_name=(TextView)convertView.findViewById(R.id.tv_name);
            myViewHolder.tv_price=(TextView)convertView.findViewById(R.id.tv_price);
            myViewHolder.et_qlty=(EditText)convertView.findViewById(R.id.et_qlty);
            myViewHolder.ratingBar=(RatingBar)convertView.findViewById(R.id.rtb);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder=(MyViewHolder)convertView.getTag();
        }
        FoodEntity mFoods=(FoodEntity)getItem(position);
        myViewHolder.tv_name.setText(mFoods.getName());
        myViewHolder.tv_price.setText(String.valueOf(mFoods.getPrice()));
        myViewHolder.et_qlty.setText(String.valueOf(mFoods.getQuality()));
        myViewHolder.ratingBar.setRating(mFoods.getStar());
        return convertView;
    }
}
