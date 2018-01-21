package com.example.admin.intent_homework;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv_name, tv_ages, tv_address;
    Button bt_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_name = (TextView) findViewById(R.id.tv_name2);
        tv_ages = (TextView) findViewById(R.id.tv_ages2);
        tv_address = (TextView) findViewById(R.id.tv_address2);
        Button bt_share = (Button) findViewById(R.id.bt_share);

        final MainActivity mainActivity = new MainActivity();
        Intent intent = getIntent();
        final Employee_Enity employee_enity = (Employee_Enity) intent.getSerializableExtra(mainActivity.DATA);

        tv_name.setText(employee_enity.getName());
        tv_ages.setText(employee_enity.getAges());
        tv_address.setText(employee_enity.getAddress());

        bt_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(mainActivity.DATA, employee_enity);

                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent1);
                }
            }
        });

    }
}
