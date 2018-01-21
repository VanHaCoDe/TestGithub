package com.example.admin.intent_homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 23/01/2016.
 */
public class My_Adapter extends BaseAdapter {
    Employee_Enity employee_enity = new Employee_Enity();
    ArrayList<Employee_Enity> arrayList = new ArrayList<>();

    public void setArrayList(ArrayList<Employee_Enity> _arrayList) {
        arrayList = _arrayList;
    }

    public static class MyViewHodel {
        TextView name, ages, adress;
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MyViewHodel viewHodel = new MyViewHodel();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout, null);

            viewHodel.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHodel.ages = (TextView) convertView.findViewById(R.id.tv_ages);
            viewHodel.adress = (TextView) convertView.findViewById(R.id.tv_address);
            convertView.setTag(viewHodel);
        } else {
           viewHodel=(MyViewHodel) convertView.getTag();
        }
        Employee_Enity employee_enity = arrayList.get(position);
        viewHodel.name.setText(employee_enity.getName());
        viewHodel.ages.setText(employee_enity.getAges());
        viewHodel.adress.setText(employee_enity.getAddress());

        return convertView;
    }
}
