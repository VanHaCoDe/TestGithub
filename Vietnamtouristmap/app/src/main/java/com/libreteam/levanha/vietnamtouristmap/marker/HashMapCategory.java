package com.libreteam.levanha.vietnamtouristmap.marker;

import com.libreteam.levanha.vietnamtouristmap.R;

import java.util.HashMap;

/**
 * Created by Admin on 2/10/2017.
 */

public class HashMapCategory {
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    public HashMapCategory() {
        setTreeMap();
    }

    public HashMap<Integer, Integer> getHashMap() {
        return hashMap;
    }


    private void setTreeMap() {
        hashMap.put(0, R.drawable.category10);
        hashMap.put(1, R.drawable.category1);
        hashMap.put(2, R.drawable.category2);
        hashMap.put(3, R.drawable.category9);
        hashMap.put(4, R.drawable.category4);
        hashMap.put(5, R.drawable.category6);
        hashMap.put(6, R.drawable.category5);
        hashMap.put(7, R.drawable.category12);
        hashMap.put(8, R.drawable.category13);
        hashMap.put(9, R.drawable.category11);
        hashMap.put(10, R.drawable.category5);
        hashMap.put(11, R.drawable.category17);
        hashMap.put(12, R.drawable.category7);
        hashMap.put(13, R.drawable.category15);
    }
}
