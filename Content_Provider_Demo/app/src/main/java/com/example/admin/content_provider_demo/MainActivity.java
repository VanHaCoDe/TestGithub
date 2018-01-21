package com.example.admin.content_provider_demo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();

        Uri uri =Uri.parse(MyContentProvider.CONTENT_URI);
        ContentValues values=new ContentValues();
        values.put("email","nhat.thdb@gmail.com");
        int resual=contentResolver.update(uri,values,null,null);
        Log.e("MainActivity",""+resual);






//        getAllContact();

    }
//
//    public void getAllContact() {
//        ContentResolver contentResolver = getContentResolver();
//        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
//        cursor.moveToFirst();
//        while (cursor.moveToNext()) {
//            // Lấy ID contact
//            String id_colum_name = ContactsContract.Contacts._ID;
//            int idIndex = cursor.getColumnIndex(id_colum_name);
//            String id = cursor.getString(idIndex);
//
//            //Lấy về tên hiện thị
//            String id_colum_display_name = ContactsContract.Contacts.DISPLAY_NAME;
//            int nameIndex = cursor.getColumnIndex(id_colum_display_name);
//            String name = cursor.getString(nameIndex);
//
//
//            Log.e("MainActivity","ID"+id+"/n Name "+name);
//        }
//    }
//    public void insertContact(){
//        ContentValues values=new ContentValues();
//
//        values.put(ContactsContract.Contacts._ID,2);
//        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
//        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER,"01658936571");
//        values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
//        Uri uri =getContentResolver().insert(ContactsContract.Data.CONTENT_URI,values);
//    }
}
