package com.example.admin.service_demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class BoundPlayMusicService extends Service {
    private android.os.Handler handler = new android.os.Handler();
    private Runnable mUpdate;

    public BoundPlayMusicService() {
    }

    public class MyBinderMusic extends Binder {
        public BoundPlayMusicService getService() {
            return BoundPlayMusicService.this;
        }

    }

    private MyBinderMusic binderMusic = new MyBinderMusic();
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        Log.e("oncreat", "oncreat");
        mediaPlayer = MediaPlayer.create(this, R.raw.sleep_away);
        super.onCreate();
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return binderMusic;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        super.onDestroy();
    }
    public int getProgress() {
        long current = mediaPlayer.getCurrentPosition();
        long durtion = mediaPlayer.getDuration();
        int progress = getProgressPercentage(current,durtion);
        return progress;
    }

    public int getProgressPercentage(long current, long duration) {
        long currenty = current /1000;
        long durationy=duration/1000;
        Log.e("currenty","  "+currenty);
        Log.e("duration","  "+durationy);
        int progressPercentage=(int)(currenty*100/durationy);
        return progressPercentage;
    }
    public void dispatchEvent() {
        Intent intent = new Intent("Update seekbar");
        Bundle bundle = new Bundle();
        int progress = getProgress();
        Log.e("Service ---------->", "progress "+progress);
        bundle.putInt("progress", progress);
        intent.putExtra("Data", bundle);
        sendBroadcast(intent);
    }
    public void playMusic() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            mUpdate = new Runnable() {
                @Override
                public void run() {
                    dispatchEvent();
                    handler.postDelayed(this, 100);
                }
            };
            handler.postDelayed(mUpdate, 100);
        }
    }



    public void pauseMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void unPauseMusic() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void stopMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }
}
