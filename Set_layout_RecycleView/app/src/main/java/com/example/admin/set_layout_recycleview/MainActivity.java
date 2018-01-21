package com.example.admin.set_layout_recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv_Layout;
    RadioGroup rdg_choceLayout;
    RadioButton rbt_LinearLayout_Vertical, Rbt_LinearLayout_Horizotal, rbt_GridLayout_Vertical, Rbt_GridLayout_Horizotal;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_Layout = (RecyclerView) findViewById(R.id.rcv_Layout);
        rdg_choceLayout = (RadioGroup) findViewById(R.id.rdg_choceLayout);
        rbt_LinearLayout_Vertical = (RadioButton) findViewById(R.id.rbt_LinearLayour_Vertical);
        Rbt_LinearLayout_Horizotal = (RadioButton) findViewById(R.id.rbt_LiearLayour_Horizotal);
        rbt_GridLayout_Vertical = (RadioButton) findViewById(R.id.rbt_GridLayout_Vertical);
        Rbt_GridLayout_Horizotal = (RadioButton) findViewById(R.id.rbt_LiearLayour_Horizotal);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        final MyAdapter adapter = new MyAdapter();

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_Layout.setLayoutManager(linearLayoutManager);
        rcv_Layout.setAdapter(adapter);

        rdg_choceLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbt_LinearLayout_Vertical.isChecked()) {
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rcv_Layout.setLayoutManager(linearLayoutManager);
                } else if (Rbt_LinearLayout_Horizotal.isChecked()) {
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    rcv_Layout.setLayoutManager(linearLayoutManager);
                } else if (rbt_GridLayout_Vertical.isChecked()) {
                    gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                    rcv_Layout.setLayoutManager(gridLayoutManager);
                } else if (Rbt_GridLayout_Horizotal.isChecked()) {
                    gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
                    rcv_Layout.setLayoutManager(gridLayoutManager);
                }
                rcv_Layout.setAdapter(adapter);
            }
        });


//        rbt_LinearLayout_Vertical.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                rcv_Layout.setLayoutManager(linearLayoutManager);
//                rcv_Layout.setAdapter(adapter);
//
//            }
//        });
//        getRbt_LinearLayout_Horizotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                rcv_Layout.setLayoutManager(linearLayoutManager);
//                rcv_Layout.setAdapter(adapter);
//            }
//        });

    }

}
