package com.example.admin.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_content;
    ListView lv_iphone;

    ArrayList<String> datas;
    Button bt_save;
    EditText et_content;
    String tmb_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_content = (TextView) findViewById(R.id.tv_content);
        lv_iphone = (ListView) findViewById(R.id.tv_content);

        //b1 tao list view
        final ArrayList<String> datas = new ArrayList<String>();
        datas.add("Nexus5");
        datas.add("iphone1");
        datas.add("iphone2");
        datas.add("iphone3");
        datas.add("iphone4");
        datas.add("iphone5");
        datas.add("iphone6");
        datas.add("lenovo");
        datas.add("Bphone");
        datas.add("Hphone");
        datas.add("haPhone");

        //b2:tao layout cho lit view
        int id_layout_for_listview = android.R.layout.simple_list_item_1;

        //b3 : tao arrayAdapter
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, id_layout_for_listview, datas);

        //b4 lien k?t arrayAdapter v?i listview
        lv_iphone.setAdapter(arrayAdapter);

        //X? l? chon item
        lv_iphone.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data_item = datas.get(position);

                ArrayList<String> list1 = new ArrayList<String>();
                ArrayList<String> list2 = new ArrayList<String>();
                for (int i = 0; i < position; i++) {
                    list1.add(datas.get(i));
                }
                for (int i = position + 1; i < datas.size(); i++) {
                    list2.add(datas.get(i));
                }


//                tv_content.setText("you slected " + data_item);
                datas.clear();
//                datas.add(position,tmb_data);

                for (int i = 0; i < list1.size(); i++) {
                    datas.add(list1.get(i));
                }
                datas.add(tmb_data);
                for (int i = 0; i < list2.size(); i++) {
                    datas.add(list2.get(i));
                }
            }
        });
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b1 l?y dl et
                String data_item = et_content.getText().toString();
                //datas.add(data_item);

                tmb_data = data_item;

                arrayAdapter.notifyDataSetChanged();
            }
        });
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View headerView = inflater.inflate(R.layout.header_listview_layout, null);

        Button bt_heder=(Button) headerView.findViewById(R.id.bt_header);
        lv_iphone.addHeaderView(headerView);
    }
}
