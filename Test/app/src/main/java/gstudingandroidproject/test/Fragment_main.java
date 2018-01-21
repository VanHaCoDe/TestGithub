package gstudingandroidproject.test;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Admin on 01/04/2016.
 */
public class Fragment_main extends Fragment {
    TextView textView;
    Button bt_speak;
    protected Locale localec;
    SpeechText speechText = new SpeechText();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.layout_fragment, null);

        textView = (TextView) rootview.findViewById(R.id.tv_test);
        bt_speak = (Button) rootview.findViewById(R.id.bt_speek);

        setSpeechText();
        bt_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rlt_main,new Fragment2()).commit();
            }
        });
        return rootview;
    }

    private void setSpeechText() {

        Intent intent = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        speechText.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", "active");

    }
}
