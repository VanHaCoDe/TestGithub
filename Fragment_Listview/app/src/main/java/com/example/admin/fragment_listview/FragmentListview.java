package com.example.admin.fragment_listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 18/02/2016.
 */
public class FragmentListview extends Fragment {
    ListView lv_people;
    ArrayList<People_Enity> arrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.item_fragment_listview, null);

        lv_people = (ListView) rootview.findViewById(R.id.lv_people);
        fakeData();
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setArraylist(arrayList);
        lv_people.setAdapter(myAdapter);

        lv_people.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                People_Enity people_enity = arrayList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("people", people_enity);

                FragmentItem fragmentItem=new FragmentItem();
                fragmentItem.setArguments(bundle);

                FragmentManager manager=getActivity().getSupportFragmentManager();
                final FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.rlt_main,fragmentItem);
                transaction.commit();
            }
        });

        return rootview;
    }

    private void fakeData() {
        People_Enity people_1 = new People_Enity();
        people_1.setName("le van ha");
        people_1.setAdress("Ha nam");
        people_1.setAges(23);
        arrayList.add(people_1);

        People_Enity people_2 = new People_Enity();
        people_2.setName("Do van hao");
        people_2.setAdress("Ha tay");
        people_2.setAges(20);
        arrayList.add(people_2);

        People_Enity people_3 = new People_Enity();
        people_3.setName("ba van dao");
        people_3.setAdress("Ha noi");
        people_3.setAges(22);
        arrayList.add(people_3);
    }
}
