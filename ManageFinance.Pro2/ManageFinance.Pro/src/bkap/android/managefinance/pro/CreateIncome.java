package bkap.android.managefinance.pro;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import bkap.android.managefinance.database.ManageFinanceDatasource;
import bkap.android.managefinance.entity.TaikhoanEntity;
import bkap.android.managefinance.entity.ThuchiEntity;

import com.example.managefinance.pro.R;

public class CreateIncome extends ActionBarActivity {

	Intent intent;

	private EditText mTxtMoTa;
	private EditText mTxtSoTien;
	private Spinner mCbLoaiTaiKhoan;

	private Button mBtnSaveIncome;
	private Button mBtnUpdateIncome;
	private Button mBtnDeleteIncome;

	private LinearLayout mLinear;

	private List<TaikhoanEntity> listAccount = new ArrayList<TaikhoanEntity>();
	private List<ThuchiEntity> listThuChi = new ArrayList<ThuchiEntity>();

	ManageFinanceDatasource database;
	IncomeActivity iA = new IncomeActivity();
	private String[] dsTaiKhoan;
	private String spinnerIncome = "";
	private int positionOfSpinner = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_income);

		/**
		 * Lấy dữ liệu từ hai bảng taikhoan và thuchi trong csdl về
		 */
		database = new ManageFinanceDatasource(this);
		database.Open();
		listAccount = database.getAccount();
		listThuChi = database.getIncome();
		database.Close();

		/**
		 * Định nghĩa các widget
		 */
		mTxtMoTa = (EditText) findViewById(R.id.txtMotaThu);
		mTxtSoTien = (EditText) findViewById(R.id.txtSoTienThu);
		mCbLoaiTaiKhoan = (Spinner) findViewById(R.id.dsTaiKhoanInCome);

		mBtnSaveIncome = (Button) findViewById(R.id.btnSaveIncome);
		mBtnUpdateIncome = (Button) findViewById(R.id.btnUpdateIncome);
		mBtnDeleteIncome = (Button) findViewById(R.id.btnDeleteIncome);

		mLinear = (LinearLayout) findViewById(R.id.LinearUpdateDeleteIncome);

		/**
		 * Tạo các giá trị cho spinner 1. Tạo 1 mảng lưu các phần tử của spinner
		 * 2. Tạo một adapter để biến đổi dữ liệu 3. truyền giá trị cho spinner
		 * 4. Sự kiện khi chọn item bên trong spinner
		 */
		// 1
		if (listAccount.size() != 0) {
			dsTaiKhoan = new String[listAccount.size()];
			for (int i = 0; i < dsTaiKhoan.length; i++) {
				dsTaiKhoan[i] = listAccount.get(i).getLoaiTaiKhoan();
			}
		}
		// 2
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.spinner, dsTaiKhoan);
		// 3
		mCbLoaiTaiKhoan.setAdapter(adapter);
		// 4
		mCbLoaiTaiKhoan.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// Các hành động khi chọn một item
				try {
					spinnerIncome = dsTaiKhoan[position];
				} catch (Exception e) {
					Toast.makeText(CreateIncome.this,
							"Không có tài khoản nào tồn tại",
							Toast.LENGTH_SHORT).show();
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				// các hành động khi ta chưa chọn item trong spinner

			}
		});

		/**
		 * Sự kiện cho các button chức năng 1. Màn hình update và delete 1.1.
		 * Update 1.2. Delete 2. Màn hình tạo mới
		 */
		if (iA.visibilityIncome == 1) {
			// 1
			mBtnSaveIncome.setVisibility(View.GONE);
			mLinear.setVisibility(View.VISIBLE);

			for (int j = 0; j < dsTaiKhoan.length; j++) {
				if (dsTaiKhoan[j].equals(listThuChi.get(iA.vitriIncome)
						.getLoaiTaiKhoan())) {
					positionOfSpinner = j;
					break;
				}
			}
			mTxtMoTa.setText(listThuChi.get(iA.vitriIncome).getMota());
			mTxtSoTien.setText(String.valueOf(listThuChi.get(iA.vitriIncome)
					.getSoTien()));
			mCbLoaiTaiKhoan.setSelection(positionOfSpinner);
			// 1.2
			mBtnDeleteIncome.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					database = new ManageFinanceDatasource(CreateIncome.this);
					database.Open();
					database.DeleteThuChi(mTxtMoTa.getText().toString());
					database.Close();
					Toast.makeText(CreateIncome.this, "Xoá thành công!",
							Toast.LENGTH_SHORT).show();
					intent = new Intent(CreateIncome.this, IncomeActivity.class);
					startActivity(intent);
					finish();
				}
			});
			// 1.1
			mBtnUpdateIncome.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {

						ThuchiEntity income = new ThuchiEntity();
						income.setHinhThuc("thu");
						income.setLoaiTaiKhoan(spinnerIncome);
						income.setMota(mTxtMoTa.getText().toString());
						income.setSoTien(Long.parseLong(mTxtSoTien.getText()
								.toString()));

						ThuchiEntity income1 = new ThuchiEntity();
						income1 = listThuChi.get(iA.vitriIncome);
						database = new ManageFinanceDatasource(CreateIncome.this);
						database.Open();
						database.UpdateThuChi(income, income1);
						database.Close();
						intent = new Intent(CreateIncome.this, IncomeActivity.class);
						startActivity(intent);
						finish();

					} catch (Exception e) {
						Toast.makeText(CreateIncome.this, "Bạn cần phải nhập số tiền", Toast.LENGTH_SHORT).show();
					}
				}
			});

		} else {
			// 2
			mBtnSaveIncome.setVisibility(View.VISIBLE);
			mLinear.setVisibility(View.GONE);

			mBtnSaveIncome.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						ThuchiEntity income = new ThuchiEntity();
						income.setHinhThuc("thu");
						income.setLoaiTaiKhoan(spinnerIncome);
						income.setMota(mTxtMoTa.getText().toString());
						income.setSoTien(Long.parseLong(mTxtSoTien.getText()
								.toString()));
						if (listThuChi.size() != 0) {
							int i = 0;
							for (; i < listThuChi.size(); i++) {
								if (listThuChi.get(i).getMota()
										.equals(mTxtMoTa.getText().toString())) {
									Toast.makeText(CreateIncome.this,
											"Mô tả không được trùng lặp",
											Toast.LENGTH_SHORT).show();
									break;
								}
							}
							if (i == listThuChi.size()) {
								database = new ManageFinanceDatasource(
										CreateIncome.this);
								database.Open();
								database.addThuChi(income);
								database.UpdateAccountIncome(income.getSoTien(),
										income.getLoaiTaiKhoan());
								database.Close();
								Toast.makeText(
										CreateIncome.this,
										"Thêm thành công khoản thu "
												+ income.getMota(),
										Toast.LENGTH_SHORT).show();
								intent = new Intent(CreateIncome.this,
										IncomeActivity.class);
								startActivity(intent);
								finish();
							}
						} else {

						}
					} catch (Exception e) {
						Toast.makeText(CreateIncome.this, "Bạn cần phải nhập số tiền", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}

		/**
		 * Điều khiển Action Bar
		 */
		ActionBar actionBar = getSupportActionBar();
		if (iA.visibilityIncome == 1) {
			actionBar.setTitle("UPDATE INCOME");
		} else {
			actionBar.setTitle("NEW INCOME");
		}
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_income, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
