package com.example.buitran.banmaytinh;

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
import android.widget.Toast;

/**
 * Created by BuiTran on 01/05/2016.
 */
public class fragment_login extends Fragment {
    EditText edt_user, edt_pass;
    Button btn_login;
    DatabaseHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        edt_user = (EditText) view.findViewById(R.id.edt_user);
        edt_pass = (EditText) view.findViewById(R.id.edt_pass);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                search();
            }
        });

        return view;
    }

    public void search() {
        String tkadmin = "admin";
        String mkadmin = "admin";
        String tk = edt_user.getText().toString();
        if (helper.searchTK(tk) == true) {
            if (edt_pass.getText().toString().equals(helper.searchPass(tk))) {
                Toast toast = Toast.makeText(getContext(), "DANG NHAP THANH CONG", Toast.LENGTH_SHORT);
                toast.show();
                gotoapp();
            } else {
                Toast toast = Toast.makeText(getContext(), "MAT KHAU KHONG DUNG", Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            if (edt_user.getText().toString().equals(tkadmin) && edt_pass.getText().toString().equals(mkadmin)) {
                gotoapp();
            } else {
                Toast toast = Toast.makeText(getContext(), "TAI KHOAN KHONG TON TAI", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void gotoapp() {

        fragment_navigation fragment_navigation = new fragment_navigation();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rtl_content, fragment_navigation);

//        Bundle bundle = new Bundle();
//        LaptopEnity laptopEnity = arrayList.get(position);
//        bundle.putSerializable("laptop_enity", laptopEnity);

//        fragment_navigation.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}

