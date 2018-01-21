package com.example.admin.set_layout_recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Admin on 12/01/2016.
 */
public class MyViewHoder extends RecyclerView.ViewHolder {
    public TextView tv_name, tv_ages, tv_adress;

    public MyViewHoder(View itemView) {
        super(itemView);

        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_ages = (TextView) itemView.findViewById(R.id.tv_ages);
        tv_adress = (TextView) itemView.findViewById(R.id.tv_adress);
    }
}

