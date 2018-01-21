package com.libreteam.levanha.maptuarist.Marker;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.libreteam.levanha.vietnamtouristmap.WebService.DataItem;
import com.libreteam.levanha.vietnamtouristmap.WebService.DataList;

import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class MarkerList {
    List<MarkerItem> markerItemList;
    DataList dataList = new DataList();

    public MarkerList() {
        setMarkerlist();
    }

    public List<MarkerItem> getMarkerItemList() {
        return markerItemList;
    }


    public void setMarkerlist() {
        List<DataItem> dataItems = dataList.getDataItems();
        for (DataItem dataItem : dataItems) {
            MarkerItem markerItem = new MarkerItem();

            double latitude = Double.parseDouble(dataItem.getLatitude());
            double longitude = Double.parseDouble(dataItem.getLongitude());
            LatLng marker = new LatLng(latitude, longitude);

            markerItem.setId(dataItem.getId());
            markerItem.setMarker(marker);
            markerItem.setCategoryId(dataItem.getCategoryId());

            markerItemList.add(markerItem);
        }
    }
}
