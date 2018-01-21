package com.example.buitran.bvnlistview1612;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_content;
    EditText edt_1;
    Button bt_ath;
    Button bt_insert;
    Button bt_atf;
    ListView lv_1;
    Button bt_clear;
    ArrayList<String> datas;
    String tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content = (TextView) findViewById(R.id.tv_content);
        edt_1 = (EditText) findViewById(R.id.edt_1);
        bt_atf = (Button) findViewById(R.id.bt_atf);
        bt_ath = (Button) findViewById(R.id.bt_ath);
        bt_insert = (Button) findViewById(R.id.bt_insert);
        lv_1 = (ListView) findViewById(R.id.lv_1);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        datas = new ArrayList<String>();
        datas.add("An");
        datas.add("Uong");
        datas.add("Nghi");
        int layout = android.R.layout.simple_expandable_list_item_1;
        final ArrayAdapter adapter = new ArrayAdapter<>(this, layout, datas);
        lv_1.setAdapter(adapter);
        lv_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data_item = datas.get(position);
                tv_content.setText(data_item);
                datas.add(position, tmp);
                datas.remove(position + 1);
            }
        });
        lv_1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                datas.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        bt_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data_items = edt_1.getText().toString();
                tmp = data_items;
                adapter.notifyDataSetChanged();
            }
        });
        LayoutInflater inflater = LayoutInflater.from(this);
        final View headerView = inflater.inflate(R.layout.layoutheaderview, null, false);
        final View footerView = inflater.inflate(R.layout.layoutfooter, null, false);
        bt_ath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv_1.addHeaderView(headerView);
            }
        });
        bt_atf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv_1.addFooterView(footerView);
            }
        });
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv_1.addFooterView(null);
                lv_1.addHeaderView(null);
                tv_content.setText("Ban Lam Gi Bay Gio?");
                edt_1.setText("Ban Muon Them Viec Gi?");
            }
        });
    }
}

