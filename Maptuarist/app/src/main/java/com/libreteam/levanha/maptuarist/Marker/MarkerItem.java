package com.libreteam.levanha.maptuarist.Marker;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Admin on 2/8/2017.
 */

public class MarkerItem {
    int id;
    int categoryId;
    LatLng marker;

    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LatLng getMarker() {
        return marker;
    }

    public void setMarker(LatLng marker) {
        this.marker = this.marker;
    }
}
