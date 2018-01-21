package com.example.admin.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView lv_food;
    ArrayList<FoodEnity> mFoods;
    myAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_food = (ListView) findViewById(R.id.lv_food);

        fakeData();
        mAdapter = new myAdapter();
        mAdapter.setListFood(mFoods);
        lv_food.setAdapter(mAdapter);
    }

    private void fakeData() {
        mFoods = new ArrayList<FoodEnity>();

        FoodEnity piazz = new FoodEnity();
        piazz.setIcon(R.drawable.female);
        piazz.setName("pizza");
        piazz.setResName("quan Piazza");
        piazz.setCost(1.2f);
        mFoods.add(piazz);

        FoodEnity iceCream = new FoodEnity();
        iceCream.setIcon(R.drawable.male);
        iceCream.setName("Ice Cream");
        iceCream.setResName("kem");
        iceCream.setCost(0.1f);
        mFoods.add(iceCream);
    }


}
