package com.example.admin.itentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String USER_NAME = "user_name";
    public static String PASS = "pass";
    public static String DATA = "data";

    EditText et_userName, et_Pass;
    Button bt_dangNhap;
    private String user_name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_userName = (EditText) findViewById(R.id.et_username);
        et_Pass = (EditText) findViewById(R.id.et_pass);
        bt_dangNhap = (Button) findViewById(R.id.bt_dangNhap);

        bt_dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = et_userName.getText().toString();
                pass = et_Pass.getText().toString();
                login();
            }
        });
    }

    private void login() {

        Intent intent = new Intent(this, Save.class);

        Bundle bundle = new Bundle();
        bundle.putString(USER_NAME, user_name);
        bundle.putString(PASS, pass);

        intent.putExtra(DATA, bundle);
//        startActivity(intent);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == 123) {
            Bundle bundle=data.getBundleExtra(DATA);
            et_userName.setText(bundle.getString(USER_NAME));
            et_Pass.setText(bundle.getString(PASS));

        }
    }
}
