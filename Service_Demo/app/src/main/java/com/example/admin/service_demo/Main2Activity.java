package com.example.admin.service_demo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button bt_bind, bt_unBind;
    private ServiceConnection serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt_bind = (Button) findViewById(R.id.bt_bind);
        bt_unBind = (Button) findViewById(R.id.bt_unbind);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e("ServiceConection", "onServiceConection");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("ServiceConection", "onServiceDisconection");
            }
        };

        bt_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService();
            }
        });
        bt_unBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unBindService();
            }
        });
    }

    public void bindService() {
        Intent intent = new Intent(Main2Activity.this, BoundService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void unBindService() {
        unbindService(serviceConnection);
    }
}
