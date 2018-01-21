package com.libreteam.levanha.vietnamtouristmap.webService;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.libreteam.levanha.vietnamtouristmap.Interface.IGetMarkerService;
import com.libreteam.levanha.vietnamtouristmap.Interface.IloadDataServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 2/7/2017.
 */

public class DataRequest implements Callback<DataList> {
    Context context;
    DataList dataList = new DataList();
    IloadDataServices iloadDataServices;


    public DataRequest(Context context, IloadDataServices iloadDataServices) {
        this.context = context;
        this.iloadDataServices = iloadDataServices;
        requsetData();
    }

    public void requsetData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" http://bwhere.vn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IGetMarkerService markerService = retrofit.create(IGetMarkerService.class);
        Call<DataList> call = markerService.loadMarker("place");
        call.enqueue(this);
        Log.e("load", "loaddata");
    }


    @Override
    public void onResponse(Call<DataList> call, Response<DataList> response) {
        dataList=response.body();
        Log.e("loadDataItem", "" + response.body().getData().size());
        iloadDataServices.loadData(dataList);
    }

    @Override
    public void onFailure(Call<DataList> call, Throwable t) {
        Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }


}
