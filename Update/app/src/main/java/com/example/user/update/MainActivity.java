package com.example.user.update;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt_update, bt_cancle;
    EditText et_Status;
    TextView tv_Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Status = (EditText) findViewById(R.id.et_Status);
        tv_Status = (TextView) findViewById(R.id.tv_Status);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_update.setEnabled(false);
        bt_update.setBackgroundColor(Color.GRAY);
        bt_cancle = (Button) findViewById(R.id.bt_cancel);
        bt_cancle.setEnabled(false);
        bt_cancle.setBackgroundColor(Color.GRAY);

        et_Status.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String s1 = et_Status.getText().toString();

                if (s1.equals("")) {
                    bt_update.setBackgroundColor(Color.GRAY);
                    bt_update.setEnabled(false);
                } else {
                    bt_update.setEnabled(true);
                    bt_update.setBackgroundColor(Color.BLUE);
                }
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Status.setText(et_Status.getText());
                bt_update.setEnabled(false);
                bt_update.setBackgroundColor(Color.GRAY);
                bt_cancle.setEnabled(true);
                bt_cancle.setBackgroundColor(Color.BLUE);
            }
        });


        bt_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_Status.setText("No Status");
                et_Status.setText(null);
                bt_cancle.setEnabled(false);
                bt_cancle.setBackgroundColor(Color.GRAY);
            }
        });
    }


}
