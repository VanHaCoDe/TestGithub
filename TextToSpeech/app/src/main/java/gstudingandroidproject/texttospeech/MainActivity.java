package gstudingandroidproject.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech ttsp;
    EditText et_text;
    Button bt_speech;
    Locale[] locale=Locale.getAvailableLocales();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        et_text = (EditText) findViewById(R.id.et_text);
        bt_speech = (Button) findViewById(R.id.bt_speech);

        ttsp = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    ttsp.setLanguage(Locale.ENGLISH);
                    ttsp.setLanguage(Locale.KOREA);

                } else {
                    Toast.makeText(getApplicationContext(), "Language not Available \n Text To Speech faoll", Toast.LENGTH_LONG).show();
                }
            }
        });
        bt_speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String speech = et_text.getText().toString();
                ttsp.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }


}
