package com.libreteam.levanha.vietnamtouristmap.webService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2/11/2017.
 */

public class DataList {

    @SerializedName("data")
    @Expose
    private List<Dataitem> data = null;


    public List<Dataitem> getData() {
        return data;
    }

    public void setData(List<Dataitem> data) {
        this.data = data;
    }
}
