package com.example.admin.intent_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et_name, et_ages, et_address;
    Button bt_add;
    ListView lv_employee;
public String DATA="data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_ages = (EditText) findViewById(R.id.et_ages);
        et_address = (EditText) findViewById(R.id.et_address);
        lv_employee = (ListView) findViewById(R.id.lv_employee);
        bt_add = (Button) findViewById(R.id.bt_add);

        final ArrayList<Employee_Enity> arrayList = new ArrayList<>();
        final My_Adapter adapter = new My_Adapter();
        adapter.setArrayList(arrayList);
        lv_employee.setAdapter(adapter);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee_Enity employee_enity = new Employee_Enity();
                employee_enity.setName(et_name.getText().toString());
                employee_enity.setAges(et_ages.getText().toString());
                employee_enity.setAddress(et_address.getText().toString());
                arrayList.add(employee_enity);
                adapter.notifyDataSetChanged();
            }
        });
        lv_employee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                Employee_Enity employee_enity=arrayList.get(position);
                intent.putExtra(DATA,employee_enity);
                startActivity(intent);

            }
        });
    }
}
