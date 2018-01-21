package com.example.frank.networkdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;
    private ProgressBar prg_status;
    private ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        prg_status = (ProgressBar) findViewById(R.id.prg_status);
        prg_status.setVisibility(View.GONE);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://lh3.googleusercontent.com/--SONYWcgLjQ/AAAAAAAAAAI/AAAAAAAAAB0/0i0lu5BJr7Y/s120-c/photo.jpg";
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(url);
            }
        });
    }


    private class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            prg_status.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // buoc1 : gui request
            String url = params[0];
            try {
                HttpResponse httpResponse = makeRequest(url);
                // buoc 2: xu ly du lieu duoc tra ve tu server
                Bitmap bitmap = processResponse(httpResponse);
                return bitmap;
            } catch (Exception e) {

            }
            return null;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            prg_status.setVisibility(View.GONE);
            if (null != bitmap) {
                img_logo.setImageBitmap(bitmap);
            }
        }
    }


    protected HttpResponse makeRequest(String url) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        return httpClient.execute(httpGet);
    }


    protected Bitmap processResponse(HttpResponse response) throws IOException {
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            byte[] data = EntityUtils.toByteArray(entity);
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            return bitmap;
        }
        return null;
    }


}
