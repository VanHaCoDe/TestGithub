package com.example.admin.jsondemo;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText tv_name, tv_email, tv_phone, tv_id;
    Button bt_start;
    RequestQueue mqueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (EditText) findViewById(R.id.tv_name);
        tv_phone = (EditText) findViewById(R.id.tv_phone);
        tv_id = (EditText) findViewById(R.id.tv_id);
        tv_email = (EditText) findViewById(R.id.tv_email);

        bt_start = (Button) findViewById(R.id.bt_start);


        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String data = "{\n" +
//                        "\"id\":12,\n" +
//                        "\"name\":\"kien\",\n" +
//                        "\"email\":\"kienttb.ptit@gmail.com\",\n" +
//                        "\"phone\":\"123456798\"\n" +
//                        "\n" +
//                        "}";
//                try {
//                    CustumerJson customer = parserJSONDATA(data);
//                    updateView(customer);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                String url = "http://dev-vn.magestore.com/simicart/1800/index.php/connector/catalog/get_product_detail/data/{\"width\":\"320\",\"product_id\":\"16\",\"height\":\"320\"}";
            }
        });

    }

    private Bitmap makeRequestUrlConection(String link) throws IOException {
        //b1 taoj httpurlconection
        URL urlconection = new URL(link);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlconection.openConnection();
        //b2 thiet lap gia tri
        //b2.1 thiet lap phuong thuc
        httpURLConnection.setRequestMethod("GET");
        //b2.2 danh dau da nhan du du lieu tu server
        httpURLConnection.setDoInput(true);
        //b2.3 thiet lap cac gia trij cua header
        String user_agent = System.getProperty("http.agent");
        httpURLConnection.setRequestProperty("http.agent", user_agent);
        //b3 nhan du lieu tu server tra ve
        InputStream in = httpURLConnection.getInputStream();
        return
    }

    private void updateView(CustumerJson custumerJson) {
        int id = custumerJson.getId();
        tv_id.setText("" + id);

        String name = custumerJson.getmName();
        tv_name.setText(name);

        String email = custumerJson.getmEmail();
        tv_email.setText(email);

        String phone = custumerJson.getmPhone();
        tv_phone.setText(phone);
    }

    private CustumerJson parserJSONDATA(String data) throws JSONException {
        JSONObject json = new JSONObject(data);
        CustumerJson custumerJson = new CustumerJson();
        if (json.has("id")) {
            String id = json.getString("id");
            custumerJson.setId(Integer.parseInt(id));
        }
        if (json.has("name")) {
            String name = json.getString("name");
            custumerJson.setmName(name);
        }
        if (json.has("email")) {
            String email = json.getString("email");
            custumerJson.setmName(email);
        }
        if (json.has("phone")) {
            String phone = json.getString("phone");
            custumerJson.setmName(phone);
        }
        return custumerJson;
    }
}
