package com.example.admin.fragment_demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Login_fragment login_fragment = new Login_fragment();
        transaction.add(R.id.rlt_main,login_fragment);
        transaction.addToBackStack("login");
        transaction.commit();
    }
}
