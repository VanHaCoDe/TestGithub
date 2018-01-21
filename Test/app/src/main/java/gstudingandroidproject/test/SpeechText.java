package gstudingandroidproject.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Admin on 31/03/2016.
 */
public class SpeechText implements Serializable {
    TextToSpeech ttsp;
    Activity activity;

    public void setContext(Activity activity) {
        this.activity = activity;
    }

    public void startTextTospeech(Activity activity) {
        if (activity == null) {
            Log.e("Activity", "null");
        } else {
            Log.e("Activity", "dont null");
        }
        setContext(activity);
    }

    public void createTextToSpeech(final Context context) {
        ttsp = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int resual = ttsp.setLanguage(Locale.getDefault());
                    if (resual == TextToSpeech.LANG_MISSING_DATA || resual == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "Sorry!  LANGUAGE " + Locale.getDefault().getDisplayLanguage() + "IS NOT SUPPORTED", Toast.LENGTH_LONG).show();
                    }
                } else
                    Toast.makeText(context, "Sorry!  TextToSpeeck Is Not Initilization", Toast.LENGTH_LONG).show();
            }
        });
    }




    public void Speak(String text, Context context) {
        ttsp.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        Toast.makeText(context, "Speaking", Toast.LENGTH_SHORT).show();
    }

    public void setLanguageVoice(Locale locale) {
        ttsp.setLanguage(locale);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("onActivityResult", "active");

    }

}
