package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAdapter {


    /*---------------------------Khoang Chi--------------------------------------*/
    public static final String colkcID = "_id";
    public static final String mathloaichi = "tenkc";
    public static final String colsotienkc = "sotien";
    public static final String colngaychi = "ngaychi";
    private static final String KhoanChiTable = "KhoanChi";



	/*-------------------------Khoan Thu-------------------------------------------*/

    public static final String colktID = "_id";
    public static final String mathloaithu = "tenkt";
    public static final String colsotienkt = "sotienkt";
    public static final String colngaythu = "ngaythu";

    private static final String KhoanthuTable = "KhoanThu";

	
	/*-------------------------Khoan Vay-------------------------------------------*/

    public static final String colkvID = "_id";
    public static final String tenkhoanvay = "tenkhoanvay";
    public static final String sotienv = "sotienkv";
    public static final String laisuatv = "laisuat";
    public static final String ngayvay = "ngayvay";
    public static final String ngaymuon = "ngaymuon";
    private static final String KhoanVayTable = "KhoanVay";
    /*-------------------------Khoan Nợ-------------------------------------------*/

    public static final String colknID = "_id";
    public static final String tenkhoanno = "tenkhoanno";
    public static final String sotienn = "sotienkv";
    public static final String laisuatn = "laisuat";
    public static final String ngayno = "ngayvay";
    public static final String ngaytrano = "ngaymuon";

    private static final String KhoanNoTable = "KhoanNo";


    /*-----------------------Create Khoang Chi---------------------------------*/
    private static final String DATABASE_KhoanChi = "CREATE TABLE "
            + KhoanChiTable + "(" + colkcID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + mathloaichi + " TEXT, "
            + colsotienkc + " Integer, "
            + colngaychi + " Date NOT NULL)";

    /*--------------------------Create Khoang Thu------------------------------*/
    private static final String DATABASE_KhoanThu = "CREATE TABLE "
            + KhoanthuTable + "("
            + colktID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + mathloaithu + " TEXT, "
            + colsotienkt + " Integer, "
            + colngaythu + " Date NOT NULL) ";

    /*----------------------------Create Khoan Vay--------------------------------*/
    private static final String DATABASE_KhoanVay = "CREATE TABLE " + KhoanVayTable
            + "("
            + colkvID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + tenkhoanvay + " TEXT, "
            + sotienv + " INTEGER, "
            + laisuatv + " Integer, "
            + ngayvay + " Date NOT NULL, "
            + ngaymuon + " Date NOT NULL"
            + ")";
    /*----------------------------Create Khoan Nợ--------------------------------*/
    private static final String DATABASE_KhoanNO = "CREATE TABLE "
            + KhoanNoTable + "(" + colknID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + tenkhoanno + " TEXT, "
            + sotienn + " INTEGER, "
            + laisuatn + " Integer, "
            + ngayno + " Date NOT NULL, "
            + ngaytrano + " Date NOT NULL)";

    private static final String DATABASE_NAME = "QuanLiTaiChinh";
    private static final int DATABASE_VERSION = 12;
    private static final String TAG = "DataAdapter";
    private final Context context;
    public static DatabaseHelpert DBHelper;
    private SQLiteDatabase db;

    public DataAdapter(Context ctx) {
        this.context = ctx;

    }

    public void createDB() {
        DBHelper = new DatabaseHelpert(context);
    }

    private static class DatabaseHelpert extends SQLiteOpenHelper {

        DatabaseHelpert(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            try {
                Log.e("Create Table", "");
                db.execSQL(DATABASE_KhoanChi);
                db.execSQL(DATABASE_KhoanThu);
                db.execSQL(DATABASE_KhoanVay);
                db.execSQL(DATABASE_KhoanNO);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            Log.w(TAG, oldVersion + " to " + newVersion
                    + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS CaNhanTable");
            onCreate(db);

        }


    }

    public DataAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

    /*-------------------------Thêm Khoản Vay----------------------------*/
    public long insertkhoanvay(String tenkv, int sotien, int laisuat, String ngayvayv, String ngaytrav) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(tenkhoanvay, tenkv);
        initialValues.put(sotienv, sotien);
        initialValues.put(laisuatv, laisuat);
        initialValues.put(ngayvay, ngayvayv);
        initialValues.put(ngaymuon, ngaytrav);
        open();
        return db.insert(KhoanVayTable, null, initialValues);
    }

    /*-------------------------Thêm Khoản No----------------------------*/
    public long insertkhoanno(String tenkn, int sotien, int laisuat, String ngayvayn, String ngaymuonn) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(tenkhoanno, tenkn);
        initialValues.put(sotienn, sotien);
        initialValues.put(laisuatn, laisuat);
        initialValues.put(ngayno, ngayvayn);
        initialValues.put(ngaytrano, ngaymuonn);

        return db.insert(KhoanNoTable, null, initialValues);
    }

    /*-------------------------Thêm Khoản Chi----------------------------*/
    public long insertkhoanchi(String matlc, int sotien, String ngaychi) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(mathloaichi, matlc);
        initialValues.put(colsotienkc, sotien);
        initialValues.put(colngaychi, ngaychi);
        open();
        return db.insert(KhoanChiTable, null, initialValues);
    }

    /*-------------------------Thêm Khoản Thu---------------------------*/
    public long insertkhoanthu(String matlt, int sotienkt, String ngaythu) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(mathloaithu, matlt);
        initialValues.put(colsotienkt, sotienkt);
        initialValues.put(colngaythu, ngaythu);
        open();
        return db.insert(KhoanthuTable, null, initialValues);
    }


    /*----------Xóa tất cả Khoan vay------------------------*/
    public int deleteAllkv() {
        return db.delete(KhoanVayTable, null, null);

    }

    /*----------Xóa tất cả Khoan No------------------------*/
    public int deleteAllkn() {

        return db.delete(KhoanNoTable, null, null);

    }

    /*----------Xóa tất cả Khoan Thu------------------------*/
    public int deleteAllkt() {

        return db.delete(KhoanthuTable, null, null);

    }
    /*----------------------Xóa id Khoan Chi----------------------*/

    public boolean deletekc(long rowId) {
        return db.delete(KhoanChiTable, colkcID + "=" + rowId, null) > 0;
    }
    /*----------------------Xóa id Khoan Thu----------------------*/

    public boolean deletekt(long rowId) {
        return db.delete(KhoanthuTable, colktID + "=" + rowId, null) > 0;
    }

	/*----------------------Xóa id khoan vay----------------------*/

    public boolean deletetkv(long rowId) {
        return db.delete(KhoanVayTable, colkvID + "=" + rowId, null) > 0;
    }
    /*----------------------Xóa id khoan No----------------------*/

    public boolean deletetkn(long rowId) {
        return db.delete(KhoanNoTable, colknID + "=" + rowId, null) > 0;
    }


    /*----------------------------liệt kê tất cả Khoan Chi----------------------*/
    public Cursor getAllkc() {
        return db.query(KhoanChiTable, new String[]{colkcID, mathloaichi, colsotienkc,
                colngaychi}, null, null, null, null, null);
    }


    /*----------------------------liệt kê tất cả Khoan Thu---------------------*/
    public Cursor getAllkt() {
        return db.query(KhoanthuTable, new String[]{colktID, mathloaithu, colsotienkt,
                colngaythu}, null, null, null, null, null);
    }


    /*----------------------------liệt kê tất cả khoản vay----------------------*/
    public Cursor getAllkv() {
        return db.query(KhoanVayTable, new String[]{colkvID,
                tenkhoanvay, sotienv, laisuatv, ngayvay, ngaymuon}, null, null, null, null, null);
    }

    /*----------------------------liệt kê tất cả khoản No----------------------*/
    public Cursor getAllkn() {
        if (db != null)
            return db.query(KhoanNoTable, new String[]{colknID,
                    tenkhoanno, sotienn, laisuatn, ngayno, ngaytrano}, null, null, null, null, null);
        return null;
    }

    /*----------------------------liệt kê _id Khoan Chi----------------------*/
    public Cursor laysotien(long sType) {
        return db.rawQuery("select coltentheloaic from KhoanChiTable where mathloaichi =\"" + sType + "\"", null);
    }

    /*--------------Liệt kê _id Khoản Vay----------------------------*/
    public Cursor getkhoanvay(long rowId) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        String ngayvay = sdf.format(new Date());
        String ngaymuon = sdf.format(new Date());
        Cursor mCursor = db.query(true, KhoanVayTable, new String[]{
                        colkvID, tenkhoanvay, sotienv, laisuatv, ngayvay, ngaymuon}, colkvID + "=" + rowId, null, null,
                null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    /*--------------Liệt kê _id Khoản No----------------------------*/
    public Cursor getkhoanno(long rowId) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        String ngayno = sdf.format(new Date());
        String ngaytrano = sdf.format(new Date());
        Cursor mCursor = db.query(true, KhoanNoTable, new String[]{
                        colknID, tenkhoanno, sotienn, laisuatn, ngayno, ngaytrano}, colknID + "=" + rowId, null, null,
                null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    /*--------------Liệt kê _id Khoản Chi----------------------------*/
    public Cursor getkhoanchi(long rowId) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        String colngaychi = sdf.format(new Date());
        Cursor mCursor = db.query(true, KhoanChiTable, new String[]{
                        colkcID, mathloaichi, colsotienkc, colngaychi}, colkcID + "=" + rowId, null, null,
                null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    /*--------------------Updater Khoan Vay----------------------------*/
    public boolean updatekhoanvay(long rowId, String name, int sotien, int laisuat, String ngayvayv, String ngaymuonv) {
        ContentValues args = new ContentValues();
        args.put(tenkhoanvay, name);
        args.put(sotienv, sotien);
        args.put(laisuatv, laisuat);
        args.put(ngayvay, ngayvayv);
        args.put(ngaymuon, ngaymuonv);
        return db.update(KhoanVayTable, args, colkvID + "=" + rowId, null) > 0;
    }

    /*--------------------Updater Khoan No----------------------------*/
    public boolean updatekhoanno(long rowId, String name, int sotien, int laisuat, String ngaynon, String ngaytra) {


        ContentValues args = new ContentValues();
        args.put(tenkhoanno, name);
        args.put(sotienn, sotien);
        args.put(laisuatn, laisuat);
        args.put(ngayno, ngaynon);
        args.put(ngaytrano, ngaytra);
        return db.update(KhoanNoTable, args, colknID + "=" + rowId, null) > 0;
    }

    /*--------------------Updater Khoan Chi----------------------------*/
    public boolean updatekhoanchi(long rowId, String name, int sotien, String ngaychi) {


        ContentValues args = new ContentValues();
        args.put(mathloaichi, name);
        args.put(colsotienkc, sotien);
        args.put(colngaychi, ngaychi);
        return db.update(KhoanChiTable, args, colkcID + "=" + rowId, null) > 0;
    }

    /*--------------------Updater Khoan Thu----------------------------*/
    public boolean updatekhoanthu(long rowId, String name, int sotienkt, String ngaythu) {


        ContentValues args = new ContentValues();
        args.put(mathloaithu, name);
        args.put(colsotienkt, sotienkt);
        args.put(colngaythu, ngaythu);
        return db.update(KhoanthuTable, args, colktID + "=" + rowId, null) > 0;
    }








}
