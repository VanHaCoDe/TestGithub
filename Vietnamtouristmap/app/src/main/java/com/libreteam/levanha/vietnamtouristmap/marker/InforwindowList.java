package com.libreteam.levanha.vietnamtouristmap.marker;

import android.content.Context;

import com.libreteam.levanha.vietnamtouristmap.webService.Category;
import com.libreteam.levanha.vietnamtouristmap.webService.Cover;
import com.libreteam.levanha.vietnamtouristmap.webService.DataList;
import com.libreteam.levanha.vietnamtouristmap.webService.Dataitem;
import com.libreteam.levanha.vietnamtouristmap.webService.Datum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class InforwindowList {
    Context context;
    List<InforwindowItem> inforwindowItemList = new ArrayList<InforwindowItem>();
    Datum datum=new Datum();

    public InforwindowList() {
        setInforwindowList();
    }

    public List<InforwindowItem> getInforwindowItemList() {
        return inforwindowItemList;
    }


    public void setInforwindowList() {
        List<Dataitem> dataItems = datum.getDataitems();
        for (Dataitem dataItem : dataItems) {
            InforwindowItem inforwindowItem = new InforwindowItem();
            Cover coverItem = dataItem.getCover().get(0);
            Category categoryItem = dataItem.getCategory();

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
