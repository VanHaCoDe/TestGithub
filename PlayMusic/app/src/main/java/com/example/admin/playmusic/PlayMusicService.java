package com.example.admin.playmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Admin on 25/01/2016.
 */
public class PlayMusicService extends Service {
    private MediaPlayer mediaPlayer ;
    public  PlayMusicService(){

    }

    public class MyBinderMusic extends Binder {
        public PlayMusicService getService() {
            return PlayMusicService.this;
        }
    }

    private MyBinderMusic myBinderMusic = new MyBinderMusic();
    int resid;

    public void getMusic(int _music) {
        resid = _music;
    }

    @Override
    public void onCreate() {
        Log.e("Oncreat","on creat");
        mediaPlayer = MediaPlayer.create(this, R.raw.sleep_away);
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("onBind","onBind");
        return myBinderMusic;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    public void PlayAndPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        }
            Log.e("play","play");
    }


}
