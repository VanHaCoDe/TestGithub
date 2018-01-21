package com.example.admin.volleyhomeworlk;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Admin on 15/08/2016.
 */
public class test {

    String url = "http://xemphim.bugs3.com/json.php";

    RequestQueue mqueue = Volley.newRequestQueue(getContext());



    private void getProductDetail(String url) {

        Response.Listener<JSONObject> processData = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        Log.e("MakeArraylist", "error");
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.e("Object " + i, jsonObject.toString());
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener processError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = error.getMessage();
                Log.e("Error ", message);

            }
        };
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, processData, processError);
        mqueue.add(jsonObjectRequest);
    }
}
