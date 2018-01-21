package com.libreteam.levanha.maptuarist.Marker;

import android.content.Context;

import com.libreteam.levanha.vietnamtouristmap.WebService.CategoryItem;
import com.libreteam.levanha.vietnamtouristmap.WebService.CoverItem;
import com.libreteam.levanha.vietnamtouristmap.WebService.DataItem;
import com.libreteam.levanha.vietnamtouristmap.WebService.DataList;

import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class InforwindowList {
    Context context;
    List<InforwindowItem> inforwindowItemList;
    DataList dataList = new DataList();

    public InforwindowList() {
        setInforwindowList();
    }

    public List<InforwindowItem> getInforwindowItemList() {
        return inforwindowItemList;
    }


    public void setInforwindowList() {
        List<DataItem> dataItems = dataList.getDataItems();
        for (DataItem dataItem : dataItems) {
            InforwindowItem inforwindowItem = new InforwindowItem();
            CoverItem coverItem = dataItem.getCover();
            CategoryItem categoryItem = dataItem.getCategory();

            inforwindowItem.setImage(coverItem.getUrl());
            inforwindowItem.setPlaceAddressvi(dataItem.getAddressVi());
            inforwindowItem.setPlaceAddressen(dataItem.getAddressEn());
            inforwindowItem.setPlaceDescriptionvi(dataItem.getShortDescriptionVi());
            inforwindowItem.setPlaceDescriptionen(dataItem.getShortDescriptionEn());
            inforwindowItem.setId(dataItem.getId());
            inforwindowItem.setCategoryNameEn(categoryItem.getNameEn());
            inforwindowItem.setCategoryNamevi(categoryItem.getNameVi());

            inforwindowItemList.add(inforwindowItem);
        }
    }


}
