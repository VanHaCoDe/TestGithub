package com.example.admin.intent_homework;

import java.io.Serializable;

/**
 * Created by Admin on 23/01/2016.
 */
public class Employee_Enity implements Serializable{
    private String name,ages,address;

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
