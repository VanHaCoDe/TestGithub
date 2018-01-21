package com.example.admin.itentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DangNhap extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dang_nhap);

        TextView tv_dn = (TextView) findViewById(R.id.tv_dn);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.DATA);

        String user_name = bundle.getString(MainActivity.USER_NAME);
        String pass = bundle.getString(MainActivity.PASS);

        tv_dn.setText("User name : " + user_name + "\nPass :" + pass);
    }

}
