package com.example.admin.service_demo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ServiceConnection mConection;
    private BoundPlayMusicService mMusicService;
    private SeekBar sb_music;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getBundleExtra("Data");
            int progress = bundle.getInt("progress");
            updateSeekbar(progress);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_start = (Button) findViewById(R.id.bt_play);
        Button bt_stop = (Button) findViewById(R.id.bt_stop);
        Button bt_next = (Button) findViewById(R.id.bt_next);

        sb_music = (SeekBar) findViewById(R.id.sb_music);


        mConection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                BoundPlayMusicService.MyBinderMusic binderMusic = (BoundPlayMusicService.MyBinderMusic) service;
                mMusicService = binderMusic.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                unbindService(mConection);
            }
        };

        Intent intent = new Intent(MainActivity.this, BoundPlayMusicService.class);
        bindService(intent, mConection, Context.BIND_AUTO_CREATE);


        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
            }
        });
        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic();
            }
        });
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });

        IntentFilter filter = new IntentFilter("Update seekbar");
        registerReceiver(mReceiver, filter);

    }

    public void playMusic() {
//        mediaPlayer.start();
//        Intent intent = new Intent(MainActivity.this, PlayMusicService.class);
//        startService(intent);
        mMusicService.playMusic();
    }

    private void updateSeekbar(int progress) {
        sb_music.setProgress(progress);
    }

    public void stopMusic() {
//        mediaPlayer.stop();
//        Intent intent = new Intent(MainActivity.this, PlayMusicService.class);
//        stopService(intent);
        mMusicService.stopMusic();
    }

    public void pauseMusic() {
        mMusicService.pauseMusic();
    }

    public void nextActivity() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void unpauseMusic() {
        mMusicService.unPauseMusic();
    }
}
