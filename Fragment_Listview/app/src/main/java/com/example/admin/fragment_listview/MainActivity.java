package com.example.admin.fragment_listview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListview fragmentListview=new FragmentListview();

        FragmentManager manager=getSupportFragmentManager();
        final FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.rlt_main,fragmentListview);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}
