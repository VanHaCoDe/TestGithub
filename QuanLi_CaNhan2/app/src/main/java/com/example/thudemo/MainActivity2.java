package com.example.thudemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import Database.DataAdapter;

public class MainActivity2 extends Activity {
    ImageButton bt_kc, bt_kt, bt_kn, bt_kv, bt_Exit, bt_info;

    public static DataAdapter data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        data = new DataAdapter(getApplicationContext());
        data.createDB();

        bt_kc = (ImageButton) findViewById(R.id.bt_kc);
        bt_kt = (ImageButton) findViewById(R.id.bt_kt);
        bt_kn = (ImageButton) findViewById(R.id.bt_kn);
        bt_kv = (ImageButton) findViewById(R.id.bt_kv);
        bt_Exit = (ImageButton) findViewById(R.id.bt_exit);
        bt_info = (ImageButton) findViewById(R.id.imgbt_info);
        bt_kc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, KhoanChi_acitive.class);
                startActivity(intent);

            }
        });
        bt_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, KhoanThu_acitive.class);
                startActivity(intent);

            }
        });
        bt_kv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, khoanvay_activite.class);
                startActivity(intent);

            }
        });
        bt_kn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, KhoanNo_acitivite.class);
                startActivity(intent);

            }
        });
        bt_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        bt_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = showInfo();
                alertDialog.show();
            }
        });
    }


    private AlertDialog showInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin nhóm phát triển");
        builder.setMessage("\t\t Thực tập tìm hiểu cơ sở dữ liệu khả chuyển Sqlite cho môi trường di động \n\n " +
                "Các thành viên:\n" +
                "\t Nguyên Đức Duy\n" +
                "\t Lê Văn Hà \n" +
                "\t Hoàng Hữu Cương");
        builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showInfo().cancel();
            }
        });

        AlertDialog dialog = builder.create();
        return dialog;
    }
}
