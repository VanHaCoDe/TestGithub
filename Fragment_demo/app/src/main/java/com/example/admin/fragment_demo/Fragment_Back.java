package com.example.admin.fragment_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 17/02/2016.
 */
public class Fragment_Back extends Fragment {
    private String name;
    public void setName(String _name){
        name=_name;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.profile_frament, null);
        TextView textView = (TextView) rootview.findViewById(R.id.tv_fra);
//        textView.setText(name);
        Bundle bundle=getArguments();
        if(bundle!=null){
            name=bundle.getString("name");
        }
        textView.setText(name);
        Button bt_back = (Button) rootview.findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backLogin();
            }
        });
        return rootview;
    }

    private void backLogin() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        Fragment fragment=manager.findFragmentByTag("login");
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.rlt_main,fragment);
        transaction.commit();
    }
}
