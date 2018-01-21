package com.libreteam.levanha.maptuarist.WebService;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2/7/2017.
 */

public class DataList {
    @SerializedName("data")
    @Expose
    static private List<DataItem> dataItems;

    public List<DataItem> getDataItems() {
        return dataItems;
    }

    public void setDataItems(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }
}
