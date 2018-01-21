package com.libreteam.levanha.maptuarist.Detail;

import com.libreteam.levanha.vietnamtouristmap.WebService.DataItem;
import com.libreteam.levanha.vietnamtouristmap.WebService.DataList;

import java.util.List;

/**
 * Created by Admin on 2/10/2017.
 */

public class DetailList {
    List<DetailItem> detailItems;
    DataList dataList = new DataList();


    public DetailList() {
        setDetailList();
    }

    public List<DetailItem> getDetailItems() {
        return detailItems;
    }

    public void setDetailList() {
        List<DataItem> dataItemList = dataList.getDataItems();
        for (DataItem dataItem : dataItemList) {
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
