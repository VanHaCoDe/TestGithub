package com.libreteam.levanha.vietnamtouristmap.marker;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.libreteam.levanha.vietnamtouristmap.webService.DataList;
import com.libreteam.levanha.vietnamtouristmap.webService.Dataitem;
import com.libreteam.levanha.vietnamtouristmap.webService.Datum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class MarkerList {
    List<MarkerItem> markerItemList = new ArrayList<MarkerItem>();
    Datum datum = new Datum();

    public MarkerList() {
        setMarkerlist();
    }

    public List<MarkerItem> getMarkerItemList() {
        return markerItemList;
    }


    public void setMarkerlist() {
        HashMapCategory hashMapCategory = new HashMapCategory();
        HashMap<Integer, Integer> hashMap = hashMapCategory.getHashMap();
        List<Dataitem> dataItems = datum.getDataitems();
        Log.e("dataItem", "" + dataItems.size());
        for (Dataitem dataItem : dataItems) {
            MarkerItem markerItem = new MarkerItem();

            double latitude = Double.parseDouble(dataItem.getLatitude());
            double longitude = Double.parseDouble(dataItem.getLongitude());
            LatLng marker = new LatLng(latitude, longitude);
            Log.e("LatLng",""+marker.toString());
            int catogoryId = dataItem.getCategoryId();

            markerItem.setId(dataItem.getId());
            markerItem.setLatLng(marker);
            markerItem.setCategoryId(catogoryId);
            Log.e("categoryId", "" + catogoryId);
            markerItem.setIconResId(hashMap.get(catogoryId));

            markerItemList.add(markerItem);
        }
    }
}
