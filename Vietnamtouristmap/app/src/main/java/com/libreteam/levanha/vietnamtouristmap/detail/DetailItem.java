package com.libreteam.levanha.vietnamtouristmap.detail;

import com.libreteam.levanha.vietnamtouristmap.webService.Image;

import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class DetailItem {
    int id;
    String placeNamevi;
    String placeNameen;
    List<Image> imageItemList;
    String decripttionVi;
    String decriptionEn;
    String addressVi;
    String addressEn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceNamevi() {
        return placeNamevi;
    }

    public void setPlaceNamevi(String placeNamevi) {
        this.placeNamevi = placeNamevi;
    }

    public String getPlaceNameen() {
        return placeNameen;
    }

    public void setPlaceNameen(String placeNameen) {
        this.placeNameen = placeNameen;
    }

    public List<Image> getImageItemList() {
        return imageItemList;
    }

    public void setImageItemList(List<Image> imageItemList) {
        this.imageItemList = imageItemList;
    }

    public String getDecripttionVi() {
        return decripttionVi;
    }

    public void setDecripttionVi(String decripttionVi) {
        this.decripttionVi = decripttionVi;
    }

    public String getDecriptionEn() {
        return decriptionEn;
    }

    public void setDecriptionEn(String decriptionEn) {
        this.decriptionEn = decriptionEn;
    }

    public String getAddressVi() {
        return addressVi;
    }

    public void setAddressVi(String addressVi) {
        this.addressVi = addressVi;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }
}
