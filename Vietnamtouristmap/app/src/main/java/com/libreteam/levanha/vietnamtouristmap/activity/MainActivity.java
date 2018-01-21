package com.libreteam.levanha.vietnamtouristmap.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.libreteam.levanha.vietnamtouristmap.R;
import com.libreteam.levanha.vietnamtouristmap.marker.MarkerItem;
import com.libreteam.levanha.vietnamtouristmap.marker.MarkerList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {
    DrawerLayout drawerLayout;

    Button btIn;
    Button btOut;
    Button btSence;
    Button btPagoda;
    Button btAtm;
    Button btFuel;

    Boolean sceneActive = true;
    Boolean pagodaActive = true;
    Boolean fuleActive = true;

    ActionBarDrawerToggle actionBarDrawerToggle;
    MarkerList markerList = new MarkerList();
    List<MarkerItem> markerItems;
    List<Marker> senceMarkers = new ArrayList<Marker>();
    List<Marker> pagodaMarker = new ArrayList<Marker>();

    List<Marker> fuleMarker = new ArrayList<Marker>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_filter_layout);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        btIn = (Button) findViewById(R.id.filter_bt_in);
        btOut = (Button) findViewById(R.id.filter_bt_out);
        btSence = (Button) findViewById(R.id.filter_bt_scene);
        btPagoda = (Button) findViewById(R.id.filter_bt_pagoda);
        btAtm = (Button) findViewById(R.id.filter_bt_atm);
        btFuel = (Button) findViewById(R.id.filter_bt_fuel);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fg_map);
        supportMapFragment.getMapAsync(this);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);


        btIn.setOnClickListener(this);
        btOut.setOnClickListener(this);
        btAtm.setOnClickListener(this);
        btFuel.setOnClickListener(this);
        btPagoda.setOnClickListener(this);
        btSence.setOnClickListener(this);

    }


    public void showAllMarker(GoogleMap googleMap) {

        markerItems = markerList.getMarkerItemList();
        Log.e("markerlist", "" + markerItems.size());
        for (MarkerItem markerItem : markerItems) {
            LatLng latLng = markerItem.getLatLng();

            int iconResId = markerItem.getIconResId();
            Log.e("add marker", "add");


            Marker marker = googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .alpha(1)
                    .icon(BitmapDescriptorFactory.fromResource(iconResId))
            );
            int categoryId = markerItem.getCategoryId();
            if (categoryId == 1) {
                pagodaMarker.add(marker);
            } else if (categoryId == 0) {
                fuleMarker.add(marker);
            } else senceMarkers.add(marker);

            Log.e("Marker ID", "" + marker.getId());

        }

    }

    public void hidenMarker(List<Marker> markers) {
        for (Marker marker : markers) {
            marker.setVisible(false);
        }
    }

    public void showMarker(List<Marker> markers) {
        for (Marker marker : markers) {
            marker.setVisible(true);
        }
    }

    public void showMylocation(GoogleMap googleMap) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            LatLng mylocation = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocation, 10));
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
        googleMap.setMyLocationEnabled(true);

        showMylocation(googleMap);

        Log.e("map", "googlemap");
        showAllMarker(googleMap);
    }

    @Override
    public void onClick(View v) {
        Log.e("id", "" + v.getId());
        switch (v.getId()) {

            case R.id.filter_bt_in:
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.filter_bt_out:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.filter_bt_pagoda:
                if (pagodaActive) {
                    hidenMarker(pagodaMarker);
                    btPagoda.setAlpha(0.3f);
                    pagodaActive = false;
                } else {
                    showMarker(pagodaMarker);
                    btPagoda.setAlpha(1.0f);
                    pagodaActive = true;
                }
                break;
            case R.id.filter_bt_atm:
                break;
            case R.id.filter_bt_fuel:
                if (fuleActive) {
                    hidenMarker(fuleMarker);
                    btFuel.setAlpha(0.3f);
                    fuleActive = false;
                } else {
                    showMarker(fuleMarker);
                    btFuel.setAlpha(1.0f);
                    fuleActive = true;

                }
                break;
            case R.id.filter_bt_scene:
                if (sceneActive) {
                    hidenMarker(senceMarkers);
                    btSence.setAlpha(0.3f);
                    sceneActive = false;
                } else {
                    showMarker(senceMarkers);
                    btSence.setAlpha(1.0f);
                    sceneActive = true;
                }
                break;
        }
    }


    private class myCustumInforwindow implements GoogleMap.InfoWindowAdapter {
        private final View myInforWindow;

        private myCustumInforwindow() {
            myInforWindow = getLayoutInflater().inflate(R.layout.pin_layout, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            ImageView imgPin = (ImageView) myInforWindow.findViewById(R.id.pin_img_lc);
            TextView tvLocationName = (TextView) myInforWindow.findViewById(R.id.pin_tv_lcName);
            TextView tvCategoryName = (TextView) myInforWindow.findViewById(R.id.pin_tv_category_name);
            TextView tvAddress = (TextView) myInforWindow.findViewById(R.id.pin_tv_adress);
            Button btNextPage = (Button) myInforWindow.findViewById(R.id.pin_bt_nextpage);


            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            return null;
        }
    }
}
