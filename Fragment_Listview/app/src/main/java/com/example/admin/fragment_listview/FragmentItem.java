package com.example.admin.fragment_listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 18/02/2016.
 */
public class FragmentItem extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.item_fragment,null);

        TextView tv_name=(TextView)rootview.findViewById(R.id.tv_namef);
        TextView tv_ages=(TextView)rootview.findViewById(R.id.tv_agef);
        TextView tv_adress=(TextView)rootview.findViewById(R.id.tv_adressf);
        Button bt_back=(Button)rootview.findViewById(R.id.bt_back);

        Bundle bundle=getArguments();
        People_Enity people_enity= (People_Enity) bundle.getSerializable("people");

        tv_name.setText("Name: "+people_enity.getName().toString());
        tv_ages.setText("Ages: "+people_enity.getAges());
        tv_adress.setText("Adress: "+people_enity.getAdress().toString());

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.popBackStack();
            }
        });

        return rootview;
    }
}
