package com.example.buitran.banmaytinh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by BuiTran on 01/05/2016.
 */
public class fragment_register extends Fragment {
    EditText edt_username,edt_password,edt_confirmpassword,edt_account,edt_email;
    Button btn_login,btn_register;
    TextView tv_register;
    DatabaseHelper helper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);
        edt_account = (EditText)view.findViewById(R.id.edt_account);
        edt_email=(EditText)view.findViewById(R.id.edt_register_email);
        edt_username = (EditText)view.findViewById(R.id.edt_register_fullname);
        edt_password = (EditText)view.findViewById(R.id.edt_register_password);
        edt_confirmpassword =(EditText)view.findViewById(R.id.edt_register_confirm_password);

        btn_register = (Button)view.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_password.getText().toString().equals(edt_confirmpassword.getText().toString())){
                    TaiKhoan kh = new TaiKhoan();
                    kh.setM_Tk(edt_account.getText().toString());
                    kh.setM_MatKhau(edt_password.getText().toString());
                    kh.setM_Ten(edt_username.getText().toString());
                    kh.setM_email(edt_email.getText().toString());
                    helper.insertTK(kh);
                    Toast toast = Toast.makeText(getContext(),"DANG KY THANH CONG",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast = Toast.makeText(getContext(),"MAT KHAU KHONG KHOP NHAU",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        return view;
    }
}
