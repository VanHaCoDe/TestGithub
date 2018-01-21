package gstudingandroidproject.voicetransplate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Admin on 31/03/2016.
 */
public class SpeechText implements Parcelable {
    TextToSpeech ttsp;
    ArrayList<String> arrayList;


    public ArrayList<String> getListVoicesupport() {
        return arrayList;
    }

    public void createTextToSpeech(final Context context) {
        ttsp = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    ttsp.setLanguage(Locale.getDefault());
                } else
                    Toast.makeText(context, "Sorry!  TextToSpeeck Is Not Initilization", Toast.LENGTH_SHORT).show();
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

    public void onActivityResult(int requestCode, int resultCode, Intent data, Context context) {
        if (requestCode == 0) {
            switch (resultCode) {
                case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS:
                    createTextToSpeech(context);
                    arrayList = data.getStringArrayListExtra(TextToSpeech.Engine.EXTRA_AVAILABLE_VOICES);
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL:
                    Toast.makeText(context, " Language Data Fail", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                    context.startActivity(intent);
            }

        }

    }
    

    protected SpeechText(Parcel in) {
        ttsp = (TextToSpeech) in.readValue(TextToSpeech.class.getClassLoader());
        if (in.readByte() == 0x01) {
            arrayList = new ArrayList<String>();
            in.readList(arrayList, String.class.getClassLoader());
        } else {
            arrayList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ttsp);
        if (arrayList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(arrayList);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SpeechText> CREATOR = new Parcelable.Creator<SpeechText>() {
        @Override
        public SpeechText createFromParcel(Parcel in) {
            return new SpeechText(in);
        }

        @Override
        public SpeechText[] newArray(int size) {
            return new SpeechText[size];
        }
    };


}
