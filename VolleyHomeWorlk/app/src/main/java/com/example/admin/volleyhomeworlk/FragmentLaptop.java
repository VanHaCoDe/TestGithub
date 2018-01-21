package com.example.admin.volleyhomeworlk;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Admin on 02/03/2016.
 */
public class FragmentLaptop extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_laptop, null);
        TextView tv_id = (TextView) rootView.findViewById(R.id.tv_id);
        TextView tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        TextView tv_type = (TextView) rootView.findViewById(R.id.tv_type);
        TextView tv_price = (TextView) rootView.findViewById(R.id.tv_price);
        TextView tv_reguler_price = (TextView) rootView.findViewById(R.id.tv_reg_price);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img_laptop);
        ProgressBar prg_image=(ProgressBar)rootView.findViewById(R.id.prg_image);
        prg_image.setVisibility(View.VISIBLE);
        Button bt_back = (Button) rootView.findViewById(R.id.bt_back);


        Bundle bundle = getArguments();
        LaptopEnity laptopEnity = (LaptopEnity) bundle.getSerializable("laptop_enity");

        tv_id.setText("ID :"+laptopEnity.getId());
        tv_name.setText("Name :"+laptopEnity.getName());
        tv_type.setText("Type :"+laptopEnity.getType());
        tv_reguler_price.setText("Reguler price :" + laptopEnity.getPrice() + " $");
        tv_reguler_price.setPaintFlags(tv_reguler_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        tv_price.setText("Price :"+laptopEnity.getPrice() + " $");
        imageView.setImageBitmap(laptopEnity.getBitmap());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prg_image.setVisibility(View.INVISIBLE);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        return rootView;
    }
}
