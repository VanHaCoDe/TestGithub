package com.example.admin.btvnlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<String>();
    Button bt_Header, bt_insert, bt_Footer, bt_clear;
    EditText et_content;
    TextView tv_header, tv_footer, tv_content;
    ListView lv;
    int kt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Header = (Button) findViewById(R.id.bt_addHd);
        bt_Footer = (Button) findViewById(R.id.bt_addFt);
        bt_insert = (Button) findViewById(R.id.bt_insert);
        tv_content = (TextView) findViewById(R.id.tv_content);
        et_content = (EditText) findViewById(R.id.et_content);
        lv = (ListView) findViewById(R.id.lv_content);


        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

        View footer = inflater.inflate(R.layout.footer, null);
        bt_clear = (Button) footer.findViewById(R.id.bt_clearAll);
        tv_footer = (TextView) footer.findViewById(R.id.tv_footer);
        lv.addFooterView(footer);

        View header = inflater.inflate(R.layout.header, null);
        tv_header = (TextView) header.findViewById(R.id.tv_header);
        lv.addHeaderView(header);

        final int id_layout_for_listview = android.R.layout.simple_list_item_1;


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, id_layout_for_listview, data);
        lv.setAdapter(adapter);


        bt_Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_header.setText(et_content.getText().toString());
            }
        });
        bt_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kt = 1;
            }

        });
        bt_Footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_footer.setText(et_content.getText().toString());
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                          if (kt == 1) {
                                              if (data.size()==0) {
                                                  data.add(position, et_content.getText().toString());
                                              }else
                                              data.add(position-1, et_content.getText().toString());
                                              ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, id_layout_for_listview, data);
                                              lv.setAdapter(adapter);
                                              kt = 0;
                                          } else {
                                              String str =data.get(position).toString();
                                              tv_content.setText(str);
                                          }

                                      }
                                  }

        );
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()

                                      {
                                          @Override
                                          public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                                                         long id) {
                                              data.remove(position - 1);
                                              ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, id_layout_for_listview, data);
                                              lv.setAdapter(adapter);
                                              return true;
                                          }
                                      }

        );
        bt_clear.setOnClickListener(new View.OnClickListener()

                                    {
                                        @Override
                                        public void onClick(View v) {
                                            data.clear();
                                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, id_layout_for_listview, data);
                                            lv.setAdapter(adapter);
                                            et_content.setText(null);
                                            tv_content.setText(null);
                                            tv_header.setText(null);
                                            tv_footer.setText(null);
                                        }
                                    }

        );
    }


}
