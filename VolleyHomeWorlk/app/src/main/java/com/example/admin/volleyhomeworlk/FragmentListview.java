package com.example.admin.volleyhomeworlk;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Admin on 01/03/2016.
 */
public class FragmentListview extends Fragment {
    RequestQueue mqueue;
    MyAdapter myAdapter = new MyAdapter();
    ListView listView;
    TextView tv_error;
    ArrayList<LaptopEnity> arrayList = new ArrayList<>();
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, null);
        listView = (ListView) view.findViewById(R.id.lv_laptop);
        tv_error = (TextView) view.findViewById(R.id.tv_error);
        progressBar = (ProgressBar) view.findViewById(R.id.prg_listview);
        progressBar.setVisibility(View.VISIBLE);


        String url = "http://dev-vn.magestore.com/simicart/1800/index.php/connector/catalog/get_all_products/data/%7B%22limit%22:%225%22,%22sort_option%22:%22None%22,%22category_id%22:%22-1%22,%22height%22:%22600%22,%22offset%22:%220%22,%22width%22:%22600%22%7D";

        mqueue = Volley.newRequestQueue(getContext());
        getProductDetail(url);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentLaptop fragmentLaptop = new FragmentLaptop();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rlt_main, fragmentLaptop);

                Bundle bundle = new Bundle();
                LaptopEnity laptopEnity = arrayList.get(position);
                bundle.putSerializable("laptop_enity", laptopEnity);

                fragmentLaptop.setArguments(bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }


    private void getProductDetail(String url) {

        Response.Listener<JSONObject> processData = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                arrayList.clear();
                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        Log.e("MakeArraylist", "error");
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        LaptopEnity laptopEnity = new LaptopEnity();
                        laptopEnity.setId(jsonObject.getString("product_id"));
                        laptopEnity.setName(jsonObject.getString("product_name"));
                        laptopEnity.setPrice(Float.parseFloat(jsonObject.getString("product_price")));
                        laptopEnity.setRglPrice(Float.parseFloat(jsonObject.getString("product_regular_price")));
                        laptopEnity.setType(jsonObject.getString("product_type"));

                        String url = jsonObject.getString("product_image");
                        getImage(url, laptopEnity);
                        arrayList.add(laptopEnity);
                    }


                    myAdapter.setArraylist(arrayList);
                    listView.setAdapter(myAdapter);

                    progressBar.setVisibility(View.INVISIBLE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener processError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String message = error.getMessage();
                tv_error.setText(message);

                progressBar.setVisibility(View.INVISIBLE);
            }
        };
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, processData, processError);
        mqueue.add(jsonObjectRequest);
    }

    private void getImage(String url, final LaptopEnity laptopEnity) {
        ImageLoader imageLoader = new ImageLoader(mqueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                Bitmap bitmap = response.getBitmap();
                if (bitmap != null) {
                    laptopEnity.setBitmap(bitmap);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }


}
