package com.example.user.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        CheckBox cb=(CheckBox)findViewById(R.id.cb_test);
        if (cb.isChecked()){
            cb.setText("Check");
        }else {
            cb.setText("UnCheck");
        }
    }
}
