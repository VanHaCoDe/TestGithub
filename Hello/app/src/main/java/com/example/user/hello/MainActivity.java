package com.example.user.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //    EditText et_demo;
    CheckBox cb_belt, cb_shoe;
    Button bt_update, bt_Clear;
    TextView tv_name, tv_price;
    RadioGroup rdg_size = (RadioGroup) findViewById(R.id.rdg_size);
    RadioButton rb_M, rb_L, rb_XL, rb_XXL;
    float price = 22;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
////
////        final TextView tv_content =(TextView) findViewById(R.id.tv_demo);
////        tv_content.setText("ANDROID is me");
////        tv_content.setTextColor(Color.parseColor("#000000"));
////        Button btTest = (Button) findViewById(R.id.bt_test);
////         et_demo=(EditText)findViewById(R.id.et_demo);
////        btTest.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Toast.makeText(MainActivity.this,"hello Android",Toast.LENGTH_SHORT).show();
////            }
////        });
//        btTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                tv_content.setText("ABC khong");
//                String content =et_demo.getText().toString();
//                tv_content.setText(content);
//            }
//        });
//        Button btTest2=(Button)findViewById(R.id.bt_test2);
//        btTest2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv_content.setText("EO");
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onClick(View v) {
//       if(v.getId()==R.id.bt_test){
//           Toast.makeText(MainActivity.this,"hello Android", Toast.LENGTH_SHORT).show();
//       }else {
//           if(v.getId()==R.id.bt_test2){
//               Toast.makeText(MainActivity.this,"hello Android 2", Toast.LENGTH_SHORT).show();
//
//           }
//       }
//    }

        cb_belt = (CheckBox) findViewById(R.id.cb_belt);
        cb_shoe = (CheckBox) findViewById(R.id.cb_shoe);
        bt_update = (Button) findViewById(R.id.bt_ud);
        bt_Clear = (Button) findViewById(R.id.bt_cl);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_price = (TextView) findViewById(R.id.tv_price);
        rb_M = (RadioButton) findViewById(R.id.rb_sM);
        rb_L = (RadioButton) findViewById(R.id.rb_sL);
        rb_XL = (RadioButton) findViewById(R.id.rb_sXL);
        rb_XXL = (RadioButton) findViewById(R.id.rb_sXXL);
        iv = (ImageView) findViewById(R.id.iv);

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText(getTextFromCheckBox());
                get_Price();
            }
        });
        bt_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_Clear();
            }
        });

    }

    private String getTextFromCheckBox() {
        StringBuilder builder = new StringBuilder();
        if (cb_belt.isChecked()) {
            iv.setImageResource(R.drawable.me);
        }
        if (cb_shoe.isChecked()) {
            String content = cb_shoe.getText().toString();
            builder.append(content);
        }
        return builder.toString();
    }

    private void setBt_Clear() {
        tv_name.setText("Name");
        cb_belt.setChecked(true);
        cb_shoe.setChecked(false);
    }

    private void get_Price() {

        rdg_size.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                float getprice = 0;
                if (checkedId == R.id.rb_sM) {
                    getprice = price + 2;
                } else if (checkedId == R.id.rb_sL) {
                    getprice = price + 3;
                } else if (checkedId == R.id.rb_sXL) {
                    getprice = price + 4;
                } else if (checkedId == R.id.rb_sXXL) {
                    getprice = price + 6;
                }
                show(getprice);
            }
        });

    }

    private void show(float getprice) {
        tv_price.setText("Price:" + getprice + "$");
    }

}