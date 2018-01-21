package com.example.user.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt_register, bt_refresh;
    RadioGroup rdg_sex;
    ImageView img_sex;
    CheckBox cb_vcb, cb_vtb, cb_agb;
    TextView tv_content;
    EditText et_us, et_pass;
    RadioButton rdb_male, rdb_female;
    String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_register = (Button) findViewById(R.id.bt_register);
        bt_refresh = (Button) findViewById(R.id.bt_refresh);
        rdg_sex = (RadioGroup) findViewById(R.id.rdg_sex);
        img_sex = (ImageView) findViewById(R.id.img_sex);
        cb_vcb = (CheckBox) findViewById(R.id.cb_vcb);
        cb_vtb = (CheckBox) findViewById(R.id.cb_vtb);
        cb_agb = (CheckBox) findViewById(R.id.cb_agb);
        tv_content = (TextView) findViewById(R.id.tv_content);
        rdb_male = (RadioButton) findViewById(R.id.rdb_male);
        rdb_female = (RadioButton) findViewById(R.id.rdb_female);

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_register();
            }
        });

        bt_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_refresh();
            }
        });

        rdg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rdb_male) {
                    img_sex.setImageResource(R.drawable.male);
                    sex = "Male";
                } else if (checkedId == R.id.rdb_female) {
                    img_sex.setImageResource(R.drawable.female);
                    sex = "Female";
                }
            }
        });
    }

    private void setBt_register() {
        String abc=("User: " + et_us.getText() + "\nPassword: " + et_pass.getText() + "\nType Card: " + type_Card() + "\nSex: " + sex);
        tv_content.setText(abc);
    }

    private void setBt_refresh() {
        tv_content.setText(null);
        et_us.setText(null);
        et_pass.setText(null);
        cb_agb.setChecked(false);
        cb_vcb.setChecked(false);
        cb_vtb.setChecked(false);
        rdb_male.setChecked(false);
        rdb_female.setChecked(false);
        img_sex.setVisibility(View.GONE);
    }

    private String type_Card() {
        String typecard = null;

        if (cb_vcb.isChecked()) {
            typecard = "VietcomBank";
        } else if (cb_vtb.isChecked()) {
            typecard = "VietinBank";
        } else if (cb_agb.isChecked()) {
            typecard = "AgriBank";
        }
        return typecard;
    }
}
