package com.example.admin.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv=(RecyclerView)findViewById(R.id.rcv);

        LinearLayoutManager ll_manager = new LinearLayoutManager(this);
        ll_manager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(ll_manager);

        //setAdapte recycleView
        MyAdapter adapter=new MyAdapter();
        rcv.setAdapter(adapter);
    }
}
