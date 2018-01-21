package com.example.admin.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 09/01/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHoder> {

    public static class MyViewHoder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_email;
        public MyViewHoder(View itemView) {
            super(itemView);

            tv_name=(TextView)itemView.findViewById(R.id.tv_name);
            tv_email=(TextView)itemView.findViewById(R.id.tv_email);
        }
    }

    public MyAdapter(){

    }

    @Override
    public MyAdapter.MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View itemView=inflater.inflate(R.layout.item_recycle_view, null);
        MyViewHoder myHoder=new MyViewHoder(itemView);

        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHoder holder, int position) {
        holder.tv_name.setText("Name"+position);
        holder.tv_email.setText("Ha"+position+".yahoo");

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
