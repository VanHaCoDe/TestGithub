package gstudingandroidproject.voicetransplate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.memetix.mst.language.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Admin on 30/03/2016.
 */
public class FragmentConversation extends Fragment implements SpeechRecognizerCallback, TranslateCallBack {
    TextView tv_input, tv_output;
    ImageButton bt_voice, bt_speech;
    ProgressBar pb_coversation;
    Spinner sp_lgOutput;
    Language lgOutput;
    ArrayList<Language> listLanguage;
    ArrayAdapter<String> adapterLanguage;
    View rootview;
    SpeechText speechText;
    LanguageAndLocale lal;
    TranslateText translateText;
    RecognizerSpeech recognizerSpeech;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rootview = inflater.inflate(R.layout.frament_conversation, container, false);
        initView();

        setClassSupport();
        setSpinner(getContext());


        sp_lgOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pb_coversation.setVisibility(View.VISIBLE);
                lgOutput = listLanguage.get(position);
                setLanguageVoice(lgOutput);
                pb_coversation.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bt_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb_coversation.setVisibility(View.VISIBLE);
                Startspeech(getContext());
            }
        });
        bt_speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_speech();
            }
        });
        return rootview;
    }

    private void initView() {

        tv_input = (TextView) rootview.findViewById(R.id.tv_input);
        tv_output = (TextView) rootview.findViewById(R.id.tv_output);
        bt_voice = (ImageButton) rootview.findViewById(R.id.bt_voice);
        bt_speech = (ImageButton) rootview.findViewById(R.id.bt_speech);
        sp_lgOutput = (Spinner) rootview.findViewById(R.id.sp_lgOutput);

        pb_coversation = (ProgressBar) rootview.findViewById(R.id.pb_conversation);
        pb_coversation.setVisibility(View.VISIBLE);
    }

    private void setClassSupport() {
        setSpeechText();
        setLanguageAndLocacle();
        setRecognizerSpeech();
        setTranslateText();
    }

    private void setBt_speech() {
        String str = tv_output.getText().toString();
        speechText.Speak(str, getContext());
    }

    private void setTranslateText() {
        translateText = new TranslateText();
        translateText.setmTRCallback(this);
    }

    private void setRecognizerSpeech() {
        recognizerSpeech = new RecognizerSpeech();
        recognizerSpeech.setmSRCallback(this);
        Log.e("SetRecognizerSpeech", "activie");
    }

    private void setLanguageAndLocacle() {

        Bundle bundle = this.getArguments();
        lal = new LanguageAndLocale(Parcel.obtain());
        lal = bundle.getParcelable("HashMap");

    }

    private void setSpeechText() {
        Bundle bundle = this.getArguments();
        speechText = new SpeechText(Parcel.obtain());
        speechText = bundle.getParcelable("TextToSpeech");

    }

    private void setSpinner(Context context) {
        setAdapter(context);
        if (adapterLanguage != null) {
            adapterLanguage.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            sp_lgOutput.setAdapter(adapterLanguage);
        } else {
            Toast.makeText(context, "SORRY! LIST LANGUAGE ERROR", Toast.LENGTH_LONG).show();
        }
        setSpinerDefault();
        pb_coversation.setVisibility(View.GONE);
    }

    private void setSpinerDefault() {
        Locale locale = Locale.getDefault();
        Language language = lal.getLanguage(locale);
        for (int i = 0; i < listLanguage.size(); i++) {
            if (language == listLanguage.get(i)) {
                sp_lgOutput.setSelection(i);
                break;
            }
        }
    }

    private void setAdapter(Context context) {
        ArrayList<String> arr = new ArrayList<>();
        listLanguage = lal.getListLanguageSupportvoice();
        for (Language language : listLanguage) {
            String str = language.name();
            arr.add(str);
        }

        adapterLanguage = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, arr);
    }


    private void setLanguageVoice(Language language) {
        Locale locale = lal.getLocaleVoice(language);
        speechText.setLanguageVoice(locale);
    }

    public void textTranslate(String input) {
        translateText.Translate_Word(input, null, lgOutput, getContext());
    }


    public void Startspeech(Context context) {
        recognizerSpeech.Recognizer(context);
    }


    @Override
    public void setinput(String input) {
        tv_input.setText(input);
        textTranslate(input);
    }

    @Override
    public void setProgressBar() {
        pb_coversation.setVisibility(View.GONE);
    }

    @Override
    public void setET_Output(String output) {
        tv_output.setText(output);
        speechText.Speak(output, getContext());
        pb_coversation.setVisibility(View.GONE);
    }


}
