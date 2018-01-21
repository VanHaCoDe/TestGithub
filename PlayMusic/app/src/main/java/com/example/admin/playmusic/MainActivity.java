package com.example.admin.playmusic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_Preview, bt_Play, bt_Repeat, bt_Next;
    ListView lv_Music;
    ServiceConnection mconect;
    PlayMusicService mService;
    ArrayList<Music_Enity> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Play = (Button) findViewById(R.id.bt_play);
        bt_Next = (Button) findViewById(R.id.bt_Next);
        bt_Preview = (Button) findViewById(R.id.bt_preview);
        bt_Repeat = (Button) findViewById(R.id.bt_repeat);

        lv_Music = (ListView) findViewById(R.id.lv_music);

        mconect = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                PlayMusicService.MyBinderMusic binderMusic = (PlayMusicService.MyBinderMusic) service;
                mService = binderMusic.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                unbindService(mconect);
            }
        };

        Intent intent = new Intent(MainActivity.this, PlayMusicService.class);
        bindService(intent, mconect, Context.BIND_AUTO_CREATE);

        int music = R.raw.sleep_away;
        bt_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.PlayAndPause();
            }
        });
        bt_Repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.onCreate();
            }
        });

    }

    public void fakeData() {
        arrayList = new ArrayList<>();

        Music_Enity kalimba = new Music_Enity();
        kalimba.setName("Kalimba");
        kalimba.setMusic(R.raw.kalimba);
        arrayList.add(kalimba);

        Music_Enity maid_with_the_flaxen_hair = new Music_Enity();
        maid_with_the_flaxen_hair.setName("Maid with the flaxen hair");
        maid_with_the_flaxen_hair.setMusic(R.raw.maid_with_the_flaxen_hair);
        arrayList.add(maid_with_the_flaxen_hair);

        Music_Enity sleep_away = new Music_Enity();
        sleep_away.setName("Sleep away");
        sleep_away.setMusic(R.raw.sleep_away);
        arrayList.add(sleep_away);
    }
}
