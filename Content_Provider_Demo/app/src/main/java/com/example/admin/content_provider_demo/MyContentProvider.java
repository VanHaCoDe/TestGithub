package com.example.admin.content_provider_demo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by BuiTran on 16/01/2016.
 */
public class MyContentProvider extends ContentProvider {
    public static String AUTHORITY = "kienttb.itplus.com.aaaaa";
    public static String CONTENT_URI = "content://" +AUTHORITY+"/user";
    private SQLiteDatabase mSQLiteDatabase;
    @Override
    public boolean onCreate() {
        mSQLiteDatabase=SQLiteDatabase.openOrCreateDatabase("user.db",null);
        openORCreateTable();
        return true;
    }
    private void openORCreateTable(){
        String query="CREATE TABLE `user` (\n" +
                "\t`ID`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Email`\tTEXT NOT NULL,\n" +
                "\t`PassWord`\tTEXT NOT NULL,\n" +
                "\t`user_name`\tTEXT NOT NULL\n" +
                ");";
        mSQLiteDatabase.execSQL(query);
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return "";
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.e("MyContentProvider", "update" + values.get("email"));
        return 100;
    }
}
