package com.libreteam.levanha.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    RelativeLayout mRelativeLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Button btClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.menu);
        btClose = (Button) findViewById(R.id.filter_bt_in);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {

            }

            public void onDrawerOpened(View drawerview) {


            }


        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        btClose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDrawer();
            }
        });

    }

    private void closeDrawer() {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }


}
