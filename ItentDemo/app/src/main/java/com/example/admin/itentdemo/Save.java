package com.example.admin.itentdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Manifest;

public class Save extends AppCompatActivity {
    EditText et_userName, et_pass, et_phone;
    Button bt_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        et_userName = (EditText) findViewById(R.id.et_username2);
        et_pass = (EditText) findViewById(R.id.et_pass2);
        et_phone = (EditText) findViewById(R.id.et_phone);

        bt_save = (Button) findViewById(R.id.bt_save);


        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                String phone = et_phone.getText().toString();
                onCall(phone);
            }
        });
    }

    public void onSave(String user_name, String pass) {
        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.USER_NAME, user_name);
        bundle.putString(MainActivity.PASS, pass);

        intent.putExtra(MainActivity.DATA, bundle);

        setResult(123, intent);

        finish();
    }

    public void onCall(String phone) {

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tell:" + phone));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        }
    }
}
