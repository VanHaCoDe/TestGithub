package gstudingandroidproject.voicetransplate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;
import android.widget.Toast;

import com.memetix.mst.language.Language;

import java.util.ArrayList;

/**
 * Created by Admin on 28/04/2016.
 */
class HistoryDatabase extends SQLiteOpenHelper {

    //Tên phiên bản
    private final int DATABASE_VESION = 1;
    //Tên cơ sở dữ liệu
    private final String DATABASE_NAME = "HISTORY_DATA.db";
    // Tên bảng
    private final String TABLE_NAME = "TRANSLATE HISTORY ";
    private final String ID = "ID";
    private final String LANGUAGE = "LANGUAGE";
    private final String TEXT = "TEXT";

    //Tạo bảng
    private String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "("
            + ID + " INTERGER PRIMARY KEY AUTOINCREMENT, "
            + LANGUAGE + " TEXT,"
            + TEXT + " TEXT"
            + ")";

    public HistoryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("Create database", "create");
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<WordTranslateEnity> getData(Context context, String language) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<WordTranslateEnity> arrayList = new ArrayList<>();
        try {
            Cursor c = db.query(TABLE_NAME, null, LANGUAGE + "=?", new String[]{language}, null, null, null);
            if (c.moveToFirst()) {
                WordTranslateEnity wordTranslateEnity = new WordTranslateEnity();
                wordTranslateEnity.setId(c.getInt(0));
                wordTranslateEnity.setLanguage(c.getString(1));
                wordTranslateEnity.setText(c.getString(2));

                arrayList.add(wordTranslateEnity);
            }
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return arrayList;
    }

    public void deleteData(Context context, String language, String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        String mgs = "";
        try {
            db.delete(TABLE_NAME, LANGUAGE + "=? and " + TEXT + "=?", new String[]{language, text});
            mgs = "Delete record is successfull";
        } catch (Exception e) {
            mgs = e.getMessage().toString();
        }
        Toast.makeText(context, mgs, Toast.LENGTH_SHORT).show();
    }

    public void addData(Context context, WordTranslateEnity word) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(LANGUAGE, word.getLanguage());
        contentValues.put(TEXT, word.getText());
        String mgs;
        if (db.insert(TABLE_NAME, null, contentValues) == -1) {
            mgs = "Failed to insert record";
        } else {
            mgs = "inssert record is successfull";
        }
        Toast.makeText(context, mgs, Toast.LENGTH_SHORT).show();

    }
}
