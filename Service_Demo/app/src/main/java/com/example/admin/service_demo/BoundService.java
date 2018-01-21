package com.example.admin.service_demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Admin on 23/01/2016.
 */
public class BoundService extends Service {
    public class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

    private MyBinder myBinder = new MyBinder();

    public BoundService() {

    }

    @Override
    public void onCreate() {
        Log.e("BounderService","onCreate");
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("BounderService","onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("BounderService","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("BounderService","onDestroy");
        super.onDestroy();
    }
}
