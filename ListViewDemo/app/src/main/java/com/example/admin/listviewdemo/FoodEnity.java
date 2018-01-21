package com.example.admin.listviewdemo;

/**
 * Created by Admin on 30/12/2015.
 */
public class FoodEnity {
    private int mIcon;
    private String mName;
    private String mResName;
    private float mCost;

    public int getIcon() {
        return mIcon;
    }

    public String getName() {
        return mName;
    }

    public String getResName() {
        return mResName;
    }

    public float getCost() {
        return mCost;
    }

    public void setIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setResName(String mResName) {
        this.mResName = mResName;
    }

    public void setCost(float mCost) {
        this.mCost = mCost;
    }
}
