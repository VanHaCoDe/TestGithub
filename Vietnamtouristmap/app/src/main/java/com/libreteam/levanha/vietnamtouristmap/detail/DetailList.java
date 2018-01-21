package com.libreteam.levanha.vietnamtouristmap.detail;

import com.libreteam.levanha.vietnamtouristmap.webService.DataList;
import com.libreteam.levanha.vietnamtouristmap.webService.Dataitem;
import com.libreteam.levanha.vietnamtouristmap.webService.Datum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class DetailList {
    List<DetailItem> detailItems=new ArrayList<DetailItem>();
    Datum datum=new Datum();


    public DetailList() {
        setDetailList();
    }

    public List<DetailItem> getDetailItems() {
        return detailItems;
    }

    public void setDetailList() {
        List<Dataitem> dataItemList = datum.getDataitems();
        for (Dataitem dataItem : dataItemList) {
            DetailItem detailItem = new DetailItem();

            detailItem.setId(dataItem.getId());
            detailItem.setImageItemList(dataItem.getImages());
            detailItem.setAddressVi(dataItem.getAddressVi());
            detailItem.setAddressEn(dataItem.getAddressEn());
            detailItem.setDecriptionEn(dataItem.getDescriptionEn());
            detailItem.setDecripttionVi(dataItem.getDescriptionVi());
            detailItem.setPlaceNameen(dataItem.getNameEn());
            detailItem.setPlaceNamevi(dataItem.getNameVi());

            detailItems.add(detailItem);
        }
    }

}
