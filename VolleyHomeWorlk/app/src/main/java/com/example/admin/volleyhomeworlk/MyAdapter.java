package com.example.admin.volleyhomeworlk;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import static com.example.admin.volleyhomeworlk.MainActivity.*;

/**
 * Created by Admin on 01/03/2016.
 */
public class MyAdapter extends BaseAdapter {


    ArrayList<LaptopEnity> arrayList = new ArrayList<>();

    public void setArraylist(ArrayList<LaptopEnity> _arraylist) {
        arrayList = _arraylist;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        convertView = layoutInflater.inflate(R.layout.item_listview, null);


        TextView tv_id = (TextView) convertView.findViewById(R.id.tv_id);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_type = (TextView) convertView.findViewById(R.id.tv_type);
        TextView tv_price = (TextView) convertView.findViewById(R.id.tv_price);
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.img_laptop);


        final LaptopEnity laptopEnity = arrayList.get(position);
        imageView.setImageBitmap(laptopEnity.getBitmap());
        tv_id.setText("ID :"+laptopEnity.getId());
        tv_name.setText("Name :" + laptopEnity.getName());
        tv_type.setText("Type :" + laptopEnity.getType());
        tv_price.setText("Price :"+laptopEnity.getPrice() + " $");



//        String link = laptopEnity.getUrlImage();

//        RequestQueue mqueue = Volley.newRequestQueue(parent.getContext());
//        ImageLoader imageLoader = new ImageLoader(mqueue, new ImageLoader.ImageCache() {
//            @Override
//            public Bitmap getBitmap(String url) {
//                return null;
//            }
//
//            @Override
//            public void putBitmap(String url, Bitmap bitmap) {
//
//            }
//        });
//        imageLoader.get(link, new ImageLoader.ImageListener() {
//            @Override
//            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
//                Bitmap bitmap = response.getBitmap();
//                if (null != bitmap) {
//                    imageView.setImageBitmap(bitmap);
//                    laptopEnity.setBitmap(bitmap);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    progressBar.setVisibility(View.INVISIBLE);
//                }
//            }
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });


        return convertView;
    }


}
