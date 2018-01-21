package gstudingandroidproject.transplateapi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText et_input;
    private TextView tv_output;
    private Button bt_traslate;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_input = (EditText) findViewById(R.id.et_input);
        tv_output = (TextView) findViewById(R.id.tv_output);
        bt_traslate = (Button) findViewById(R.id.bt_translate);

        bt_traslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et_input.getText().toString();
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(str);
                tv_output.setText(text);
            }
        });
    }


    private class MyAsyncTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            String str = params[0];
            Translate.setClientId("GAOOOOOO");
            Translate.setClientSecret("qQxTSGZiq0qq0/4HniG+ZfipaaeB/7XNeqrYiAwl9N4=");
            try {
                Log.e("translate", "translate1");
                String text = Translate.execute(str, Language.ENGLISH, Language.VIETNAMESE);
                Log.e("translate", "translate2");
                return text;
            } catch (Exception e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text = s;
        }


    }
}
