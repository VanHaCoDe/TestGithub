package gstudingandroidproject.voicetransplate;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.memetix.mst.language.Language;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Admin on 23/03/2016.
 */
public class FragmentTranslate extends Fragment implements TranslateCallBack, SpeechRecognizerCallback {
    Spinner sp_lgInput, sp_lgOutput;
    EditText et_input, et_output;
    ImageButton bt_spInput, bt_spOutput, bt_transplate;
    ProgressBar pb_translate;

    Language lgInput, lgOutput;
    ArrayList<Language> listLanguage;
    ArrayAdapter<String> adapterLanguage;
    RecognizerSpeech recognizerSpeech;
    TranslateText translateText;
    LanguageAndLocale lal;
    SpeechText speechText;
    View rootview;

    public void setLgInput(Language lgInput) {
        this.lgInput = lgInput;
    }

    public void setLgOutput(Language lgOutput) {
        this.lgOutput = lgOutput;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.translate_fragment, container, false);
        initView();
        setSupportClass();


        setSpinner(getContext());

        sp_lgInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                initInputLanguage(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_lgOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                intitOutputLanguage(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt_transplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_transplate();
            }
        });

        bt_spInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_spInput();
            }
        });

        bt_spOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBt_spOutput();
            }
        });

        return rootview;
    }


    private void initView() {
        sp_lgInput = (Spinner) rootview.findViewById(R.id.sp_language1);
        sp_lgOutput = (Spinner) rootview.findViewById(R.id.sp_language2);
        et_input = (EditText) rootview.findViewById(R.id.et_input);
        et_output = (EditText) rootview.findViewById(R.id.et_output);
        bt_spInput = (ImageButton) rootview.findViewById(R.id.bt_speech1);
        bt_spOutput = (ImageButton) rootview.findViewById(R.id.bt_speech2);
        bt_transplate = (ImageButton) rootview.findViewById(R.id.bt_transplate);
        pb_translate = (ProgressBar) rootview.findViewById(R.id.pb_translate);
        pb_translate.setVisibility(View.GONE);
    }

    private void setSupportClass() {
        setRecognizerSpeech();
        setTranslateText();
        setSpeechText();
        setLanguageAndLoacle();
    }

    private void setRecognizerSpeech() {
        recognizerSpeech = new RecognizerSpeech();
        recognizerSpeech.setmSRCallback(this);
    }

    private void setTranslateText() {
        translateText = new TranslateText();
        translateText.setmTRCallback(this);
    }

    private void setSpeechText() {
        Bundle bundle = this.getArguments();
        speechText = new SpeechText(Parcel.obtain());
        speechText = bundle.getParcelable("TextToSpeech");
    }

    private void setLanguageAndLoacle() {
        Bundle bundle = this.getArguments();
        lal = new LanguageAndLocale(Parcel.obtain());
        lal = bundle.getParcelable("HashMap");
    }

    private void initInputLanguage(int position) {
        Language language = listLanguage.get(position);
        setLgInput(language);
        Log.e("check input", lgInput.name());
    }

    private void intitOutputLanguage(int position) {
        Language language = listLanguage.get(position);
        setLgOutput(language);
        Log.e("check output", lgOutput.name());
        try {
            Locale locale = lal.getLocaleVoice(lgOutput);
            Log.e("check locale", locale.getDisplayLanguage());
            speechText.setLanguageVoice(locale);
            bt_spOutput.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Toast.makeText(getContext(), "This language dont support voice", Toast.LENGTH_SHORT).show();
            bt_spOutput.setVisibility(View.GONE);
        }

    }


    private void setBt_transplate() {
        Log.e("check", " language" + lgOutput.name());
        pb_translate.setVisibility(View.VISIBLE);
        String input = et_input.getText().toString();
        translateText.Translate_Word(input, lgInput, lgOutput, getContext());
    }

    private void setBt_spInput() {
        pb_translate.setVisibility(View.VISIBLE);
        recognizerSpeech.Recognizer(getContext());
    }

    private void setBt_spOutput() {
        String output = et_output.getText().toString();
        speechText.Speak(output, getContext());
    }

    private void setSpinner(Context context) {
        ArrayAdapter<String> adapter = getAdapter(context);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sp_lgInput.setAdapter(adapter);
        sp_lgOutput.setAdapter(adapter);
        setSpinerDefault();
    }

    private void setSpinerDefault() {
        Locale locale = Locale.getDefault();
        try {
            Language language = lal.getLanguage(locale);
            for (int i = 0; i < listLanguage.size(); i++) {
                if (language.equals(listLanguage.get(i))) {
                    sp_lgInput.setSelection(i);
                }
            }
        } catch (Exception e) {

        }

    }

    private ArrayAdapter<String> getAdapter(Context context) {
        if (listLanguage == null) {
            Log.e("abc", "abc2");
            Language[] languages = Language.values();
            ArrayList<String> arr = new ArrayList<>();
            listLanguage = new ArrayList<>();
            for (Language language : languages) {
                listLanguage.add(language);
                String str = language.name();
                arr.add(str);

            }
            arr.remove(0);
            listLanguage.remove(0);
            adapterLanguage = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, arr);
            return adapterLanguage;
        }
        Log.e("abc", "abc");
        return adapterLanguage;

    }


    @Override
    public void setinput(String input) {
        et_input.setText(input);
        translateText.Translate_Word(input, lgInput, lgOutput, getContext());
    }

    @Override
    public void setProgressBar() {
        pb_translate.setVisibility(View.GONE);
    }

    @Override
    public void setET_Output(String output) {
        et_output.setText(output);
        pb_translate.setVisibility(View.GONE);
    }


}
