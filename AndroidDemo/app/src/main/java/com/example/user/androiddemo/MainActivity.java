package com.example.user.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button TimeButton, nButton, btTAndAD, bt_Check, bt_EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        final EditText et = (EditText) findViewById(R.id.et_testime);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.showSoftInput(et, 0);
            }
        });
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER){
                    imm.hideSoftInputFromWindow(et.getWindowToken(),0);
                }
                return true;
            }
        });

        TimeButton = (Button) findViewById(R.id.btTime);
        TimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeButton.setText(new Date().toString());
            }
        });
        nButton = (Button) findViewById(R.id.btOC);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2.class);
                startActivity(intent);
            }
        });
        btTAndAD = (Button) findViewById(R.id.btTAndAD);
        btTAndAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, test_Toast_Activity.class);
                startActivity(intent);
            }
        });
        bt_Check = (Button) findViewById(R.id.bt_check);
        bt_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        });
        bt_EditText = (Button) findViewById(R.id.bt_EditText);
        bt_EditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
            }
        });

//        TextView text=new TextView(this);
//        text.setText("Hello");
//        setContentView(text);

    }


}

