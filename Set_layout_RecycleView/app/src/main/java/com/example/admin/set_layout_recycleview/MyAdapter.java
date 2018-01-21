package com.example.admin.set_layout_recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 12/01/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View item_view=inflater.inflate(R.layout.item_recycleview, null);

        MyViewHoder viewHoder=new MyViewHoder(item_view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
        holder.tv_name.setText("name "+position);
        holder.tv_ages.setText("Ages "+position);
        holder.tv_adress.setText("Adress "+position);

    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
