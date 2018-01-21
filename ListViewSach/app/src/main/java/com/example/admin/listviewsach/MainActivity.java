package com.example.admin.listviewsach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et_name, et_quality, et_price;
    Button bt_delete, bt_add;
    ListView lv_sach;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_mName);
        et_quality = (EditText) findViewById(R.id.et_mQlty);
        et_price = (EditText) findViewById(R.id.et_mPrice);
        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        lv_sach = (ListView) findViewById(R.id.lv_sach);

        final ArrayList<Sach_Enity> sach_enityArrayList = new ArrayList<Sach_Enity>();
        myAdapter = new MyAdapter();
        myAdapter.setSach_enityArrayList(sach_enityArrayList);
        lv_sach.setAdapter(myAdapter);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sach_Enity sach_enity = new Sach_Enity();
                sach_enity.setName(et_name.getText().toString());
                sach_enity.setQuality(Float.parseFloat(et_quality.getText().toString()));
                sach_enity.setPrice(Float.parseFloat(et_price.getText().toString()));
                sach_enityArrayList.add(sach_enity);

                myAdapter.setSach_enityArrayList(sach_enityArrayList);
                lv_sach.setAdapter(myAdapter);
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sach_enityArrayList.clear();

                myAdapter.setSach_enityArrayList(sach_enityArrayList);
                lv_sach.setAdapter(myAdapter);
            }
        });


    }


    public class MyAdapter extends BaseAdapter {

        ArrayList<Sach_Enity> sach_enityArrayList;

        public void setSach_enityArrayList(ArrayList<Sach_Enity> sach) {
            sach_enityArrayList = sach;
        }

        @Override
        public int getCount() {
            return sach_enityArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return sach_enityArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_sach, null);

            final Sach_Enity sach_enity = (Sach_Enity) getItem(position);

            TextView name = (TextView) convertView.findViewById(R.id.tv_name);
            name.setText(sach_enity.getName());

            TextView price = (TextView) convertView.findViewById(R.id.tv_price);
            price.setText(String.valueOf(sach_enity.getPrice()));

            EditText quality = (EditText) convertView.findViewById(R.id.et_Qlty);
            quality.setText(String.valueOf(sach_enity.getQuality()));

            RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.rtb_sach);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    sach_enity.setClick(sach_enity.getClick() + 1);
                    sach_enity.setRating((int) (sach_enity.getRating() + rating));
                    rating = sach_enity.getRating() / sach_enity.getClick();
                    ratingBar.setRating(rating);

                }
            });

            Button update = (Button) convertView.findViewById(R.id.bt_update);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et_name.setText(sach_enity.getName());
                    et_quality.setText(String.valueOf(sach_enity.getQuality()));
                    et_price.setText(String.valueOf(sach_enity.getPrice()));
                    sach_enity.setQuality(Float.parseFloat(et_quality.getText().toString()));

                }
            });
            Button X = (Button) convertView.findViewById(R.id.bt_x);
            X.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sach_enityArrayList.remove(position);
                    myAdapter.notifyDataSetChanged();

                }
            });
            return convertView;
        }
    }
}
