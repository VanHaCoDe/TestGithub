package com.libreteam.levanha.myapplication;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.libreteam.levanha.myapplication.Interface.IGetMarkerService;
import com.libreteam.levanha.myapplication.WebService.DataList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<DataList> {
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://bwhere.vn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IGetMarkerService iGetMarkerService = retrofit.create(IGetMarkerService.class);
        Call<DataList> dataListCall = iGetMarkerService.loadMarker("place");
        dataListCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<DataList> call, Response<DataList> response) {
        if (response.isSuccessful()) {
            Log.e("response", "" + response.body().getData().size());
        }
        else Log.e("error","null");
    }

    @Override
    public void onFailure(Call<DataList> call, Throwable t) {

    }
}
