package fstudingandroidproject.jsoupexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    private class jsoup extends AsyncTask {
        String tile,src;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Object doInBackground(Object[] params) {
            try {
                Document document= Jsoup.connect("https://learnenglishkids.britishcouncil.org/en/short-stories").get();
                Elements elements = document.select("div.field-content");
                Element element=elements.get(1);
                tile=element.getElementsByTag("img").last().text();
                src=element.getElementsByTag("img").first().text();
                Log.e("",tile);
                Log.e("",src);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }
}
