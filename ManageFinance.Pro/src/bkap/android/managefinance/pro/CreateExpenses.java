package bkap.android.managefinance.pro;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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

public class CreateExpenses extends ActionBarActivity {

	Intent intent;
	private EditText mTxtMoTa;
	private Spinner mCbTaiKhoan;
	private EditText mTxtSoTien;
	private Button mBtnSave;
	private Button mBtnUpdate;
	private Button mBtnDelete;
	private LinearLayout mLinear;
	private String spinnerSelected = "";

	ExpenseActivity eA = new ExpenseActivity();
	ManageFinanceDatasource datasource;
	List<TaikhoanEntity> listAccount = new ArrayList<TaikhoanEntity>();
	List<ThuchiEntity> listThuChi = new ArrayList<ThuchiEntity>();
	String[] dsAccount;
	private ThuchiEntity expenseBanDau = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_expenses);

		ActionBar actionBar = getSupportActionBar();
		if (eA.visibilityExpense == 1) {
			actionBar.setTitle("UPDATE EXPENSE");
		} else {
			actionBar.setTitle("NEW EXPENSE");
		}
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));
		actionBar.setDisplayHomeAsUpEnabled(true);

		datasource = new ManageFinanceDatasource(CreateExpenses.this);
		datasource.Open();
		listAccount = datasource.getAccount();
		listThuChi = datasource.getExpense();
		datasource.Close();

		if (listAccount.size() != 0) {
			dsAccount = new String[listAccount.size()];
			for (int i = 0; i < 2; i++) {

				dsAccount[i] = listAccount.get(i).getLoaiTaiKhoan();

			}
		}
		Log.e("ds", "" + dsAccount.length);
		mTxtMoTa = (EditText) findViewById(R.id.txtMotaChi);
		mCbTaiKhoan = (Spinner) findViewById(R.id.dsTaiKhoan);
		mTxtSoTien = (EditText) findViewById(R.id.txtSoTienChi);

		mBtnSave = (Button) findViewById(R.id.btnSaveExpense);
		mBtnUpdate = (Button) findViewById(R.id.btnUpdateExpense);
		mBtnDelete = (Button) findViewById(R.id.btnDeleteExpense);

		mLinear = (LinearLayout) findViewById(R.id.LinearUpdateDeleteExpense);

		ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(
				CreateExpenses.this, R.layout.spinner, dsAccount);
		mCbTaiKhoan.setAdapter(adapterSpinner);

		Log.e("lit thu", " : " + listThuChi.size());
		if (listThuChi.size() != 0) {
			for (int ds = 0; ds < listAccount.size(); ds++) {
				if (dsAccount[ds].equals(listThuChi.get(eA.vitriExpense)
						.getLoaiTaiKhoan())) {
					mCbTaiKhoan.setSelection(ds);
					break;
				}
			}
		}
		mCbTaiKhoan.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				spinnerSelected = listAccount.get(position).getLoaiTaiKhoan();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});

		if (eA.visibilityExpense == 1) {
			mBtnSave.setVisibility(View.GONE);
			mLinear.setVisibility(View.VISIBLE);

			mTxtMoTa.setText(listThuChi.get(eA.vitriExpense).getMota());
			Log.e("lít thu chi", listThuChi.size() + "");

			mTxtSoTien.setText(String.valueOf(listThuChi.get(eA.vitriExpense)
					.getSoTien()));

			expenseBanDau = new ThuchiEntity();
			expenseBanDau = listThuChi.get(eA.vitriExpense);

			mBtnDelete.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					datasource = new ManageFinanceDatasource(
							CreateExpenses.this);
					datasource.Open();
					datasource.DeleteThuChi(listThuChi.get(eA.vitriExpense)
							.getMota());
					datasource.Close();
					Toast.makeText(CreateExpenses.this, "Xóa thành công!",
							Toast.LENGTH_SHORT).show();
					intent = new Intent(CreateExpenses.this,
							ExpenseActivity.class);
					startActivity(intent);
					finish();
				}
			});

			mBtnUpdate.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {

						ThuchiEntity expense = new ThuchiEntity();
						expense.setHinhThuc("chi");
						expense.setLoaiTaiKhoan(spinnerSelected);
						Log.e("update spinner", spinnerSelected);

						Log.e("old account", expenseBanDau.getLoaiTaiKhoan());
						expense.setMota(mTxtMoTa.getText().toString());
						expense.setSoTien(Long.parseLong(mTxtSoTien.getText()
								.toString()));
						datasource = new ManageFinanceDatasource(
								CreateExpenses.this);
						datasource.Open();
						datasource.UpdateThuChi(expense, expenseBanDau);
						datasource.Close();

						Toast.makeText(
								CreateExpenses.this,
								"Cập nhật thành công khoản khoản chi "
										+ expense.getMota(), Toast.LENGTH_SHORT)
								.show();
						intent = new Intent(CreateExpenses.this,
								ExpenseActivity.class);
						startActivity(intent);
						finish();
					} catch (Exception e) {
						Toast.makeText(CreateExpenses.this,
								"Bạn cần phải nhập số tiền", Toast.LENGTH_SHORT)
								.show();
					}
				}
			});

		} else {
			mBtnSave.setVisibility(View.VISIBLE);
			mLinear.setVisibility(View.GONE);

			mBtnSave.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						if (listThuChi.size() != 0) {

							int i = 0;
							for (; i < listThuChi.size(); i++) {
								if (mTxtMoTa.getText().toString()
										.equals(listThuChi.get(i).getMota())) {
									Toast.makeText(CreateExpenses.this,
											"Bạn cần nhập mô tả khác",
											Toast.LENGTH_SHORT).show();
									break;
								}
							}

							if (i == listThuChi.size()) {
								ThuchiEntity expense = new ThuchiEntity();
								expense.setHinhThuc("chi");
								expense.setLoaiTaiKhoan(spinnerSelected);
								expense.setMota(mTxtMoTa.getText().toString());
								expense.setSoTien(Long.parseLong(mTxtSoTien
										.getText().toString()));
								datasource = new ManageFinanceDatasource(
										CreateExpenses.this);
								datasource.Open();
								datasource.addThuChi(expense);
								datasource.UpdateAccountExpense(
										expense.getSoTien(), spinnerSelected);
								datasource.Close();
								Toast.makeText(
										CreateExpenses.this,
										"Thêm thành công khoản chi "
												+ expense.getMota(),
										Toast.LENGTH_SHORT).show();
								intent = new Intent(CreateExpenses.this,
										ExpenseActivity.class);
								startActivity(intent);
								finish();

							}

						} else {
							ThuchiEntity expense = new ThuchiEntity();
							expense.setHinhThuc("chi");
							expense.setLoaiTaiKhoan(spinnerSelected);
							expense.setMota(mTxtMoTa.getText().toString());
							expense.setSoTien(Long.parseLong(mTxtSoTien
									.getText().toString()));
							datasource = new ManageFinanceDatasource(
									CreateExpenses.this);
							datasource.Open();
							datasource.addThuChi(expense);
							datasource.UpdateAccountExpense(
									expense.getSoTien(), spinnerSelected);
							datasource.Close();
							Toast.makeText(
									CreateExpenses.this,
									"Thêm thành công khoản chi "
											+ expense.getMota(),
									Toast.LENGTH_SHORT).show();
							intent = new Intent(CreateExpenses.this,
									ExpenseActivity.class);
							startActivity(intent);
							finish();

						}
					} catch (Exception e) {
						Toast.makeText(CreateExpenses.this,
								"Bạn cần phải nhập số tiền", Toast.LENGTH_SHORT)
								.show();
					}
				}
			});
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expenses, menu);
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
