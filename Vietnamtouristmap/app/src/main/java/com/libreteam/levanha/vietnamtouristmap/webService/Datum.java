package com.libreteam.levanha.vietnamtouristmap.webService;

import java.util.List;

/**
 * Created by Admin on 2/11/2017.
 */

public class Datum {
    static private List<Dataitem> dataitems = null;

    public static List<Dataitem> getDataitems() {
        return dataitems;
    }

    public static void setDataitems(List<Dataitem> dataitems) {
        Datum.dataitems = dataitems;
    }
}
