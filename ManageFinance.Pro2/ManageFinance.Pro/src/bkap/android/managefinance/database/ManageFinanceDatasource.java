package bkap.android.managefinance.database;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import bkap.android.managefinance.entity.TaikhoanEntity;
import bkap.android.managefinance.entity.ThuchiEntity;

public class ManageFinanceDatasource {
	private SQLiteDatabase database;
	private DatabaseHelper dataHelper;
	private String[] allColumnTaiKhoan = new String[] { "loaitaikhoan", "mota",
			"sotien" };
	private String[] allColumnThuChi = new String[] { "hinhthuc", "mota",
			"loaitaikhoan", "sotien" };

	/**
	 * Khởi tạo dataHelper
	 * 
	 * @param context
	 */
	public ManageFinanceDatasource(Context context) {
		dataHelper = new DatabaseHelper(context);
	}

	/**
	 * Cho phép viết lên CSDL
	 * 
	 * @throws SQLException
	 */
	public void Open() throws SQLException {
		database = dataHelper.getWritableDatabase();
	}

	public void Close() {
		dataHelper.close();
	}

	/**
	 * lấy dữ liệu về tài khoản từ CSDL
	 * 
	 * @return một danh sách các tài khoản lưu trong CSDL
	 */
	public ArrayList<TaikhoanEntity> getAccount() {
		ArrayList<TaikhoanEntity> listAccount = new ArrayList<TaikhoanEntity>();
		Cursor cursor = database.query("taikhoan", allColumnTaiKhoan, null,
				null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			TaikhoanEntity taikhoan = new TaikhoanEntity();
			taikhoan = getDataAccount(cursor);
			listAccount.add(taikhoan);
			cursor.moveToNext();

		}
		cursor.close();
		return listAccount;
	}

	/**
	 * Phương thức thực hiện việc thêm dữ liệu vào bảng taikhoan
	 * 
	 * @param taikhoan
	 */
	public void AddAccount(TaikhoanEntity taikhoan) {
		database.execSQL("insert into taikhoan values('"
				+ taikhoan.getLoaiTaiKhoan() + "','" + taikhoan.getMota()
				+ "'," + taikhoan.getSoTien() + ");");
	}

	/**
	 * sửa dữ liệu bảng tài khoản
	 * 
	 * @param taikhoan
	 *            : Tài khoản sau khi thay đổi
	 * @param taikhoan1
	 *            : Tài khoản ban đầu
	 */
	public void UpdateAccount(TaikhoanEntity taikhoan, TaikhoanEntity taikhoan1) {
		database.execSQL("update taikhoan set loaitaikhoan='"
				+ taikhoan.getLoaiTaiKhoan() + "',mota='" + taikhoan.getMota()
				+ "',sotien=" + taikhoan.getSoTien() + " where loaitaikhoan='"
				+ taikhoan1.getLoaiTaiKhoan() + "'");
	}

	/**
	 * Sửa số tiền khi người dùng thêm vào khoản thu
	 * 
	 * @param long : số tiền thêm vào tài khoản
	 * @param loaitaikhoan : tài khoản được cộng thêm tiền
	 */
	public void UpdateAccountIncome(long tien, String loaitaikhoan) {
		database.execSQL("update taikhoan set sotien = (sotien + " + tien
				+ ") where loaitaikhoan='" + loaitaikhoan + "'");
	}

	/**
	 * Sửa số tiền khi người dùng sử dụng tiền trong tài khoản để chi tiêu
	 * 
	 * @param tien : Số tiền mà người đó chi
	 * @param loaitaikhoan : Loại tài khoản được sử dụng
	 */

	public void UpdateAccountExpense(long tien, String loaitaikhoan) {
		database.execSQL("update taikhoan set sotien = (sotien - " + tien
				+ ") where loaitaikhoan='" + loaitaikhoan + "'");
	}

	/**
	 * Phương thức thực hiện việc xóa dữ liệu trong bảng tài khoản theo điều
	 * kiện
	 */

	public void DeleteAccount(String loaiTaiKhoan) {
		database.execSQL("delete from taikhoan where loaitaikhoan='"
				+ loaiTaiKhoan + "'");
	}

	/**
	 * Lấy dữ liệu chi tiêu của người sử dụng
	 * 
	 * @return danh sách những khoản người dùng đã chi
	 */
	public ArrayList<ThuchiEntity> getExpense() {
		ArrayList<ThuchiEntity> listExpense = new ArrayList<ThuchiEntity>();
		// Cursor cursor = database.query("thuchi", allColumnThuChi,
		// null, null, null, null, null);
		Cursor cursor = database.rawQuery(
				"select * from thuchi where hinhthuc='chi'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			ThuchiEntity expense = new ThuchiEntity();
			expense = getDataExpense(cursor);
			listExpense.add(expense);
			cursor.moveToNext();
		}
		cursor.close();
		return listExpense;
	}

	/**
	 * Phương thức thêm một khoản thu hoặc chi
	 */

	public void addThuChi(ThuchiEntity thuchi) {
		database.execSQL("insert into thuchi values('" + thuchi.getHinhThuc()
				+ "','" + thuchi.getMota() + "','" + thuchi.getLoaiTaiKhoan()
				+ "'," + thuchi.getSoTien() + ");");
	}

	/**
	 * Phương thức sửa khoản thu hoặc chi
	 */
	public void UpdateThuChi(ThuchiEntity thuchi, ThuchiEntity thuchi1) {
		database.execSQL("update thuchi set hinhthuc='" + thuchi.getHinhThuc()
				+ "',mota='" + thuchi.getMota() + "',loaitaikhoan='"
				+ thuchi.getLoaiTaiKhoan() + "',sotien=" + thuchi.getSoTien()
				+ " where mota='" + thuchi1.getMota() + "'");
	}

	/*
	 * Phương thức sửa bảng thuchi khi chúng ta thay đổi loại tài khoản trong bảng taikhoan
	 */
	public void ChangeThuChi(String taikhoanMoi, String taikhoanCu) {
		database.execSQL("update thuchi set loaitaikhoan='" + taikhoanMoi
				+ "' where loaitaikhoan='" + taikhoanCu + "'");
	}

	/**
	 * Phương thức xóa trong bảng thuchi
	 */

	public void DeleteThuChi(String mota) {
		database.execSQL("delete from thuchi where mota='" + mota + "'");
	}

	/**
	 * Lấy dữ liệu thu nhập của người sử dụng
	 * 
	 * @return danh sách những khoản người dùng đã nhận được
	 */
	public ArrayList<ThuchiEntity> getIncome() {
		ArrayList<ThuchiEntity> listIncome = new ArrayList<ThuchiEntity>();
		Cursor cursor = database.rawQuery(
				"select * from thuchi where hinhthuc='thu'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			ThuchiEntity expense = new ThuchiEntity();
			expense = getDataExpense(cursor);
			listIncome.add(expense);
			cursor.moveToNext();
		}
		cursor.close();
		return listIncome;
	}

	/**
	 * phương thức getDataAccount giúp ta lấy dữ liệu từ cursor
	 * 
	 * @param cursor
	 *            : Dữ liệu lấy từ CSDL
	 * @return Một đối tượng thuộc kiểu TaikhoanEntity
	 */
	public TaikhoanEntity getDataAccount(Cursor cursor) {
		TaikhoanEntity taikhoan = new TaikhoanEntity();
		taikhoan.setLoaiTaiKhoan(cursor.getString(cursor
				.getColumnIndex("loaitaikhoan")));
		taikhoan.setMota(cursor.getString(cursor.getColumnIndex("mota")));
		taikhoan.setSoTien(cursor.getInt(cursor.getColumnIndex("sotien")));
		return taikhoan;
	}

	/**
	 * Phương thức getDataExpense giúp ta lấy dữ liệu từ cursor
	 * 
	 * @param cursor
	 * @return
	 */
	public ThuchiEntity getDataExpense(Cursor cursor) {
		ThuchiEntity expense = new ThuchiEntity();
		expense.setHinhThuc(cursor.getString(cursor.getColumnIndex("hinhthuc")));
		expense.setMota(cursor.getString(cursor.getColumnIndex("mota")));
		expense.setLoaiTaiKhoan(cursor.getString(cursor
				.getColumnIndex("loaitaikhoan")));
		expense.setSoTien(cursor.getLong(cursor.getColumnIndex("sotien")));
		return expense;
	}
}
