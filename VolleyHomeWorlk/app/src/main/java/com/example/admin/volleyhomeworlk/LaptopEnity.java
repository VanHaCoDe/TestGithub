package com.example.admin.volleyhomeworlk;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;

import java.io.Serializable;

/**
 * Created by Admin on 01/03/2016.
 */
public class LaptopEnity implements Serializable {
    private String id, name, type;
    private Float price, rglPrice;
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRglPrice() {
        return rglPrice;
    }

    public void setRglPrice(Float rglPrice) {
        this.rglPrice = rglPrice;
    }
}
