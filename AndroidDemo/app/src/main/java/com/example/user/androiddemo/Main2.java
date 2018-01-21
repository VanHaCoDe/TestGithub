package com.example.user.androiddemo;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class Main2 extends Activity {
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.layout2);
//        Button btBack=(Button) findViewById(R.id.btBack);
//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Main2.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });

    }
    public void displayTime(View v){
        Button btTime2=(Button)findViewById(R.id.btTime2);
        btTime2.setText(new Date().toString());

    }
}
