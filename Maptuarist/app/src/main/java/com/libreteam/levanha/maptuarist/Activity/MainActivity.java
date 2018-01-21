package com.libreteam.levanha.maptuarist.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.libreteam.levanha.vietnamtouristmap.Marker.MarkerItem;
import com.libreteam.levanha.vietnamtouristmap.Marker.MarkerList;
import com.libreteam.levanha.vietnamtouristmap.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    DrawerLayout drawerLayout;
    GoogleMap googleMap;
    Button bt_in;
    Button bt_out;
    Button bt_sence;
    Button bt_pagoda;
    Button bt_atm;
    Button bt_fuel;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_filter_layout);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        bt_in = (Button) findViewById(R.id.filter_bt_in);
        bt_out = (Button) findViewById(R.id.filter_bt_out);
        bt_sence = (Button) findViewById(R.id.filter_bt_scene);
        bt_pagoda = (Button) findViewById(R.id.filter_bt_pagoda);
        bt_atm = (Button) findViewById(R.id.filter_bt_atm);
        bt_fuel = (Button) findViewById(R.id.filter_bt_fuel);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fg_map);
        supportMapFragment.getMapAsync(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        bt_in.setOnClickListener(onClickListener);
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.filter_bt_in:
                    drawerLayout.closeDrawer(Gravity.LEFT);
                case R.id.filter_bt_out:
                    drawerLayout.openDrawer(Gravity.LEFT);
                case R.id.filter_bt_pagoda:
                case R.id.filter_bt_atm:
                case R.id.filter_bt_fuel:
                case R.id.filter_bt_scene:
            }
        }
    };

    public int getCategory(int categoryID) {
        switch (categoryID) {
            case 1:
                return R.drawable.category1;
            case 2:
                return R.drawable.category6;
            case 3:
                return R.drawable.category9;
            case 4:
                return R.drawable.category2;
            case 5:
                return R.drawable.category6;
            case 6:
                return R.drawable.category5;
            case 7:
                return R.drawable.category12;
            case 8:
                return R.drawable.category13;
            case 9:
                return R.drawable.category11;
            case 10:
                return R.drawable.category14;
            case 11:
                return R.drawable.category17;
            case 12:
                return R.drawable.category7;
            case 13:
                return R.drawable.category15;
        }
        return categoryID;
    }

    public void showAllMarker(GoogleMap googleMap) {
        MarkerList markerList = new MarkerList();
        List<MarkerItem> markerItems = markerList.getMarkerItemList();
        for (MarkerItem markerItem : markerItems) {
            LatLng marker = markerItem.getMarker();
            int categoryId = markerItem.getCategoryId();
            int icon = getCategory(categoryId);

           googleMap.addMarker(new MarkerOptions()
                    .position(marker)
                    .alpha(1)
                    .icon(BitmapDescriptorFactory.fromResource(icon))
            );
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        this.googleMap = googleMap;
        googleMap.setMyLocationEnabled(true);
        showAllMarker(googleMap);
    }

}
