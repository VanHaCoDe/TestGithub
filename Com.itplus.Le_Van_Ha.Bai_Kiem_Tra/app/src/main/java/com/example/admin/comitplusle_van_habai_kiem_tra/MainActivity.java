package com.example.admin.comitplusle_van_habai_kiem_tra;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Products_Enity> arrayList = new ArrayList<Products_Enity>();
    ListView lv_product;
    Button bt_add, bt_update, bt_delete;
    EditText et_name, et_description, et_price;
    SQLiteDatabase sqLiteDatabase;
    MyAdapter adapter = new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_description = (EditText) findViewById(R.id.et_description);
        et_price = (EditText) findViewById(R.id.et_price);

        bt_add = (Button) findViewById(R.id.bt_add);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_delete = (Button) findViewById(R.id.bt_delete);

        lv_product = (ListView) findViewById(R.id.lv_product);


        initDatabase();
        creatTable();

//        fakeData();
        setArrayList();


        lv_product.setAdapter(adapter);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String description = et_description.getText().toString();
                String price = et_price.getText().toString();

                addDatabase(name, description, price);
                setArrayList();


            }
        });
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String description = et_description.getText().toString();
                String price = et_price.getText().toString();

                updateDatabase(description, price, name);
                setArrayList();
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                deleteData(name);
                setArrayList();
            }
        });


    }

    public void fakeData() {

        addDatabase("sach", "giao khoa", "12000");
        addDatabase("sach", "giao khoa", "12000");
        addDatabase("sach", "giao khoa", "12000");
    }


    public void initDatabase() {

        String datbase_name = "MyDatabase.db";

        Log.e("Creat Database", "");
        sqLiteDatabase = openOrCreateDatabase(datbase_name, MODE_PRIVATE, null);
    }

    public void creatTable() {
        String query = "CREATE TABLE IF NOT EXISTS `product` (\n" +
                "\t`ID`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Name`\tTEXT NOT NULL,\n" +
                "\t`Price`\tTEXT NOT NULL,\n" +
                "\t`Description`\tTEXT NOT NULL\n" +
                ");";

        sqLiteDatabase.execSQL(query);

    }

    public void addDatabase(String valueName, String valuedecription, String valueprice) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", valueName);
        contentValues.put("Description", valuedecription);
        contentValues.put("Price", valueprice);

        sqLiteDatabase.insert("product", null, contentValues);

    }


    public void updateDatabase(String valueDescription, String valuePrice, String name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Description", valueDescription);
        contentValues.put("Price", valuePrice);
        sqLiteDatabase.update("product", contentValues, "Name=?", new String[]{name});

    }

    public void deleteData(String name) {

        sqLiteDatabase.delete("product", "Name=?", new String[]{name});

    }

    public void setArrayList() {

        arrayList.clear();
        Cursor cursor = sqLiteDatabase.query("product", null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Products_Enity products_enity = new Products_Enity();
            products_enity.setName(cursor.getString(1));
            products_enity.setPrice(Float.parseFloat(cursor.getString(2)));
            products_enity.setDescription(cursor.getString(3));
            arrayList.add(products_enity);
            cursor.moveToNext();
        }
        adapter.setArrayList(arrayList);
        adapter.notifyDataSetChanged();
    }


}
