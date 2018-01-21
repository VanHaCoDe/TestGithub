package com.example.admin.fragment_listview;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Admin on 18/02/2016.
 */
public class People_Enity implements Serializable {
    private String name,adress;
    private int ages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }
}
