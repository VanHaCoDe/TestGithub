package com.example.frank.networkdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.volleydemo.R;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;
    private ProgressBar prg_status;
    private ImageView img_logo;
    private RequestQueue mQueue;
    private TextView tv_name;
    private TextView tv_id;
    private TextView tv_phone;
    private TextView tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        prg_status = (ProgressBar) findViewById(R.id.prg_status);
        prg_status.setVisibility(View.GONE);

        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_name = (TextView) findViewById(R.id.tv_name);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://lh3.googleusercontent.com/--SONYWcgLjQ/AAAAAAAAAAI/AAAAAAAAAB0/0i0lu5BJr7Y/s120-c/photo.jpg";
                //reqeustWithVolley(url);

            }
        });
        mQueue = Volley.newRequestQueue(this);
    }

    private void getProductDetail(String url) {
        prg_status.setVisibility(View.VISIBLE);

        Response.Listener<JSONObject> processData = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                prg_status.setVisibility(View.GONE);
                String data = response.toString();
                tv_name.setText(data);
            }
        };

        Response.ErrorListener processError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                prg_status.setVisibility(View.GONE);
                String message = error.getMessage();
                tv_email.setText(message);
            }
        };

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, processData, processError);
        mQueue.add(jsonRequest);
    }


    protected void reqeustWithVolley(String link) {
        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }   });
        imageLoader.get(link, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                Bitmap bitmap = response.getBitmap();
                if (null != bitmap) {
                    img_logo.setImageBitmap(bitmap);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }


}
