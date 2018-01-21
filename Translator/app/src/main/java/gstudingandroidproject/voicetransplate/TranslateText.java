package gstudingandroidproject.voicetransplate;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * Created by Admin on 22/03/2016.
 */
public class TranslateText {
    Language lgInput, lgOutput;
    Context context;
    TranslateCallBack mTRCallback;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setmTRCallback(TranslateCallBack mTRCallback) {
        this.mTRCallback = mTRCallback;
    }

    public void setLgInput(Language lgInput) {
        this.lgInput = lgInput;
    }

    public void setLgOutput(Language lgOutput) {
        this.lgOutput = lgOutput;
    }

    public void Translate_Word(String input, Language _lgInput, Language _lgOutput, Context context) {
        setContext(context);
        setLgInput(_lgInput);
        setLgOutput(_lgOutput);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(input);
        Toast.makeText(context, "Translating.........", Toast.LENGTH_SHORT).show();

    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            String str = params[0];
            Translate.setClientId("GAOOOOOO");
            Translate.setClientSecret("qQxTSGZiq0qq0/4HniG+ZfipaaeB/7XNeqrYiAwl9N4=");
            try {
                String str2;
                if (lgInput != null) {
                    str2 = Translate.execute(str, lgInput, lgOutput);
                    return str2;
                } else {
                str2 = Translate.execute(str, lgOutput);
                return str2;
                }

            } catch (Exception e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mTRCallback.setET_Output(s);
        }


    }
}
