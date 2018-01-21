package gstudingandroidproject.voicetransplate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by Admin on 24/03/2016.
 */
public class FragmentMain extends Fragment {
    Button bt_cvst, bt_tspl;
    SpeechText speechText;
    LanguageAndLocale lal;
    Bundle bundle;
    FragmentConversation fragment_conversation;
    FragmentTranslate fragmentTranslate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        bt_cvst = (Button) rootView.findViewById(R.id.bt_coversation);
        bt_tspl = (Button) rootView.findViewById(R.id.bt_trans);

        createLanguageAndLocale();
        creatTextToSpeech();
        setBundle();

        fragment_conversation = new FragmentConversation();
        fragment_conversation.setArguments(bundle);
        fragmentTranslate = new FragmentTranslate();
        fragmentTranslate.setArguments(bundle);


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        bt_cvst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.e("Conversation", "conversation");
                fragmentTransaction.replace(R.id.rlt_main, fragment_conversation);
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
        bt_tspl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Translate ", "translate y");
                fragmentTransaction.replace(R.id.rlt_main, fragmentTranslate);
                fragmentTransaction.addToBackStack(null).commit();

            }
        });
    }

    private void creatTextToSpeech() {
        speechText = new SpeechText();
        CheckIntent();
    }

    private void createLanguageAndLocale() {
        lal = new LanguageAndLocale();
    }

    public void CheckIntent() {
        Intent intent = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent, 0);
    }

    private void setBundle() {
        bundle = new Bundle();
        bundle.putSerializable("HashMap", lal);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        speechText.onActivityResult(requestCode, resultCode, data, getContext());
        setHashMap();
    }


    public void setHashMap() {
        try {
            ArrayList<String> arrayList = speechText.getListVoicesupport();
            Log.e("arraylist", " " + arrayList.size());
            lal.setHashMap(arrayList);
            bt_cvst.setEnabled(true);
            bt_cvst.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Toast.makeText(getContext(), "DONT HAVE TTS ENGINE", Toast.LENGTH_SHORT).show();
            bt_cvst.setEnabled(false);
            bt_cvst.setVisibility(View.GONE);
        }

    }
}
