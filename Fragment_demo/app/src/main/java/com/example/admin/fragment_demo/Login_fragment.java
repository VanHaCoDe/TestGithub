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
import android.widget.EditText;

/**
 * Created by Admin on 17/02/2016.
 */
public class Login_fragment extends Fragment {
    @Nullable

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.layout_fragmentview, null);
        final EditText et_name = (EditText) rootview.findViewById(R.id.et_name);
        Button login = (Button) rootview.findViewById(R.id.bt_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                gotoProfile(name);
            }
        });
        return rootview;

    }

    private void gotoProfile(String name) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment_Back fragment_back = new Fragment_Back();
//        fragment_back.setName(name);
        Bundle bundle=new Bundle();
        bundle.putString("name",name);
        fragment_back.setArguments(bundle);
        transaction.replace(R.id.rlt_main,fragment_back );
        transaction.addToBackStack("back");
        transaction.commit();
    }
}


