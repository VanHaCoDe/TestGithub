package com.example.admin.playmusic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by Admin on 27/01/2016.
 */
public class My_Adapter extends BaseAdapter {
    ArrayList<Music_Enity> arrayList;

    public void getArrayList(ArrayList<Music_Enity> music_enityArrayList) {
        arrayList = music_enityArrayList;
    }

    public class ViewHoder {
        private TextView Name;
        private TextView ID;
    }

    @Override
    public int getCount() {
        return 0;
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHoder viewHoder = new ViewHoder();
        if (viewHoder == null) {
            convertView=inflater.inflate(R.layout.item_listview,null);
            viewHoder.Name=(TextView)convertView.findViewById(R.id.tv_name);
            viewHoder.ID=(TextView)convertView.findViewById(R.id.tv_id);

            convertView.setTag(viewHoder);
        }else {
            convertView.getTag();
        }
            Music_Enity music_enity=arrayList.get(position);
            viewHoder.Name.setText(music_enity.getName());
            viewHoder.ID.setText(music_enity.getMusic());
        return convertView;
    }
}
