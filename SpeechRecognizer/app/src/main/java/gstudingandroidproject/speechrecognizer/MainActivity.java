package gstudingandroidproject.speechrecognizer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SpeechRecognizer speechRecognizer;
    TextView tv_lable;
    Button bt_speech;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_lable = (TextView) findViewById(R.id.tv_lable);
        bt_speech = (Button) findViewById(R.id.bt_speech);

        Boolean ckeck = checkSpeechRecognizer(getApplicationContext());
        if (ckeck == false) {
            tv_lable.setText("Sorry! Your Phone Dont Support Speech Recognizer Device");
        }
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getApplicationContext());
        speechRecoginerListener listener = new speechRecoginerListener();
        speechRecognizer.setRecognitionListener(listener);

        bt_speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_lable.setText("Hello");

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"Speech Now");
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                try {
                    Log.e("Start listen","Start listen");
                    speechRecognizer.startListening(intent);
                }catch (Exception e){
                    tv_lable.setText(e.toString());
                }
            }
        });

    }

    public boolean checkSpeechRecognizer(Context context) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> list = pm.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        Boolean aviable = true;
        if (list.size() == 0) {
            aviable = false;
        }
        return aviable;
    }

    class speechRecoginerListener implements RecognitionListener {

        @Override
        public void onReadyForSpeech(Bundle params) {

        }

        @Override
        public void onBeginningOfSpeech() {

        }

        @Override
        public void onRmsChanged(float rmsdB) {

        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onError(int error) {
            tv_lable.setText("Error Code " + error);
        }

        @Override
        public void onResults(Bundle results) {
            Log.e("On resulte","On results");
            arrayList = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            String str=arrayList.get(0);
            tv_lable.setText(str);
        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    }


}
