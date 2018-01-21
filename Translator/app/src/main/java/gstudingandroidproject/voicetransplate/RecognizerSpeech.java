package gstudingandroidproject.voicetransplate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 22/03/2016.
 */
public class RecognizerSpeech {
    SpeechRecognizer speechRecognizer;
    SpeechRecognizerCallback mSRCallback;

    public void setmSRCallback(SpeechRecognizerCallback mSRCallback) {

        this.mSRCallback = mSRCallback;
    }

    String option;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOption(String option) {
        this.option = option;
    }


    public void Recognizer(Context _context) {
        setContext(_context);
        Toast.makeText(context, "Speech Now", Toast.LENGTH_SHORT).show();
        setOption(option);
        speechRecoginerListener listener = new speechRecoginerListener();

        Boolean aboolean = checkSpeechRecognizer(context);
        if (aboolean == false) {
            Toast.makeText(context, "Error ! My phone dont support Recognizer Device", Toast.LENGTH_SHORT).show();
        } else {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
            speechRecognizer.setRecognitionListener(listener);
            startSpeech(context);
            Toast.makeText(context, "Speech Now", Toast.LENGTH_SHORT);
        }

    }


    public void startSpeech(Context context) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "Speech Here Now");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        try {
            Log.e("Start listen", "Start listen");
            speechRecognizer.startListening(intent);
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    public boolean checkSpeechRecognizer(Context context) {
        boolean aviable = speechRecognizer.isRecognitionAvailable(context);
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
            switch (error) {
                case 1:
                    Toast.makeText(context, "Error code " + error + " ERROR_NETWORK_TIMEOUT ", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(context, "Error code " + error + " ERROR_NETWORK ", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(context, "Error code " + error + " ERROR_AUDIO ", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(context, "Error code " + error + " ERROR_SERVER ", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(context, "Error code " + error + " ERROR_CLIENT ", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    Toast.makeText(context, "Error code " + error + " ERROR_SPEECH_TIMEOUT ", Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    Toast.makeText(context, "Error code " + error + " ERROR_NO_MATCH ", Toast.LENGTH_SHORT).show();
                    break;
                case 8:
                    Toast.makeText(context, "Error code " + error + " ERROR_RECOGNIZER_BUSY ", Toast.LENGTH_SHORT).show();
                    break;
                case 9:
                    Toast.makeText(context, "Error code " + error + " ERROR_INSUFFICIENT_PERMISSIONS ", Toast.LENGTH_SHORT).show();
                    break;


            }
            mSRCallback.setProgressBar();
        }

        @Override
        public void onResults(Bundle results) {
            ArrayList<String> arrayList = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            String str = arrayList.get(0);
            Log.e("input", "" + str);
            mSRCallback.setinput(str);
        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    }

}
