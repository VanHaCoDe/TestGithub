package com.example.admin.listview_phone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lv_phone;
    ArrayList<PhoneEnity> phone = new ArrayList<PhoneEnity>();
    TextView tv_call;
    MyAdapte mphones = new MyAdapte();

    public void setTextView(String text){
        tv_call.setText(text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_phone = (ListView) findViewById(R.id.lv_phone);
        tv_call = (TextView) findViewById(R.id.tv_call);

        mphones.setMain(this);
        fakeData();

        mphones.setListPhone(phone);
        lv_phone.setAdapter(mphones);


    }

    public void fakeData() {

        PhoneEnity Ong = new PhoneEnity();
        Ong.setIcon(R.drawable.female);
        Ong.setNumberPhone("01653249875");
        phone.add(Ong);

        PhoneEnity Ba = new PhoneEnity();
        Ba.setIcon(R.drawable.male);
        Ba.setNumberPhone("01689532475");
        phone.add(Ba);
    }

    public class MyAdapte extends BaseAdapter {
        ArrayList<PhoneEnity> mPhone;
        MainActivity main;

        public void setMain(MainActivity main) {
            this.main = main;
        }

        public void setListPhone(ArrayList<PhoneEnity> phone) {
            mPhone = phone;
        }

        @Override
        public int getCount() {
            return mPhone.size();
        }

        @Override
        public Object getItem(int position) {
            return mPhone.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {


            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_phone, null);

            final PhoneEnity phoneEnity = (PhoneEnity) getItem(position);

            ImageView imag = (ImageView) convertView.findViewById(R.id.imgv_phone);
            imag.setImageResource(phoneEnity.getIcon());

            final TextView textView = (TextView) convertView.findViewById(R.id.tv_numberPhone);
            textView.setText(phoneEnity.getNumberPhone());

            final Button button = (Button) convertView.findViewById(R.id.bt_call);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    tv_call.setText(phoneEnity.getNumberPhone());
                    main.setTextView(phoneEnity.getNumberPhone());
                }
            });

            return convertView;
        }
    }
}
