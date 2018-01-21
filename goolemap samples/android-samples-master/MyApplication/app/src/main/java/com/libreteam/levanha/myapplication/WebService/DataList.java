package com.libreteam.levanha.myapplication.WebService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2/11/2017.
 */

public class DataList {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("data")
    @Expose
    private List<Dataitem> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Dataitem> getData() {
        return data;
    }

    public void setData(List<Dataitem> data) {
        this.data = data;
    }
}
