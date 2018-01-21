package com.example.admin.service_demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class PlayMusicService extends Service {
    private MediaPlayer mediaPlayer;
    public PlayMusicService() {
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("play music service","onStartCommand");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.e("Oncreate","on Create");



        mediaPlayer=MediaPlayer.create(this,R.raw.sleep_away);
        mediaPlayer.setLooping(false);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("Play Service","onDestroy");
        if (null!=mediaPlayer){
            mediaPlayer.stop();
        }
        super.onDestroy();
    }
}
