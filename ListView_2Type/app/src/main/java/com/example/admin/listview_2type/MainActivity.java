package com.example.admin.listview_2type;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_food;
    ArrayList<FoodEntity> mFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_food = (ListView) findViewById(R.id.lv_food);
        for (int i=1;i<1000;i++){
            FoodEntity pizza=new FoodEntity();
            pizza.setName("food"+i);
            pizza.setPrice(8.3f);
            pizza.setStar(3);
            pizza.setQuality(5);
            mFood.add(pizza);
        }
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setArrayList(mFood);
        lv_food.setAdapter(myAdapter);
    }
    private void fakeData(){
        FoodEntity pizza=new FoodEntity();
        pizza.setName("Pizza");
        pizza.setPrice(8.3f);
        pizza.setStar(3);
        pizza.setQuality(5);
        mFood.add(pizza);

        FoodEntity banana=new FoodEntity();
        pizza.setName("Banana");
        pizza.setPrice(8.3f);
        pizza.setStar(3);
        pizza.setQuality(5);
        mFood.add(banana);

        FoodEntity apple=new FoodEntity();
        pizza.setName("Apple");
        pizza.setPrice(8.3f);
        pizza.setStar(3);
        pizza.setQuality(5);
        mFood.add(apple);

        FoodEntity soup=new FoodEntity();
        pizza.setName("Soup");
        pizza.setPrice(8.3f);
        pizza.setStar(3);
        pizza.setQuality(5);
        mFood.add(soup);

        FoodEntity rice=new FoodEntity();
        pizza.setName("Rice");
        pizza.setPrice(8.3f);
        pizza.setStar(3);
        pizza.setQuality(5);
        mFood.add(rice);



    }
}
