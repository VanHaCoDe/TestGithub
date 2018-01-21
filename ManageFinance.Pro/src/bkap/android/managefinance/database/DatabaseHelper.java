package bkap.android.managefinance.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	/**
	 * managefinance : tên Database 
	 * 1 : version của phiên bản Database này (ở đây ta không cần thay đổi nên để cứng là 1)
	 * 
	 * @param context
	 */
	public DatabaseHelper(Context context) {
		super(context, "managefinance", null, 1);
	}

	/**
	 * Khởi tạo 2 bảng 
	 * taikhoan : lưu danh sách các tài khoản của người dùng.
	 * thuchi : dùng để lưu danh sách các khoản thu chi của người sử dụng.
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table taikhoan(loaitaikhoan text primary key,mota text, sotien long)");
		db.execSQL("create table thuchi(hinhthuc text not null, mota text not null, loaitaikhoan text not null, sotien long not null)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
