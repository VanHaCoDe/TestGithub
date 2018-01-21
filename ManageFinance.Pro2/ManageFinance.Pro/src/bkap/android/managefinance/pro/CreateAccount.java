package bkap.android.managefinance.pro;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Parser;

import bkap.android.managefinance.database.ManageFinanceDatasource;
import bkap.android.managefinance.entity.TaikhoanEntity;

import com.example.managefinance.pro.R;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CreateAccount extends ActionBarActivity {

	private EditText mTxtTaiKhoan;
	private EditText mTxtMoTa;
	private EditText mTxtSoTien;

	private Button mBtnSave;
	private Button mBtnUpdate;
	private Button mBtnDelete;

	private LinearLayout linear;
	TaikhoanEntity taikhoan1 = new TaikhoanEntity();

	private ManageFinanceDatasource datasource;
	private List<TaikhoanEntity> listAccount = new ArrayList<TaikhoanEntity>();

	AccountActivity aA = new AccountActivity();
	Intent intent;

	MediaPlayer player = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_account);

		RelativeLayout relative = (RelativeLayout) findViewById(R.id.relative);

		Animation animation = AnimationUtils.loadAnimation(CreateAccount.this,
				R.anim.animation_layout_left);
		relative.startAnimation(animation);

		ActionBar actionBar = getSupportActionBar();
		if (aA.i == 1) {
			actionBar.setTitle("UPDATE ACCOUNT");
		} else {
			actionBar.setTitle("NEW ACCOUNT");
		}
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));
		actionBar.setDisplayHomeAsUpEnabled(true);
		datasource = new ManageFinanceDatasource(CreateAccount.this);
		datasource.Open();

		mTxtTaiKhoan = (EditText) findViewById(R.id.txtTaikhoan);
		mTxtMoTa = (EditText) findViewById(R.id.txtMota);
		mTxtSoTien = (EditText) findViewById(R.id.txtSoTien);
		listAccount = datasource.getAccount();
		datasource.Close();

		mBtnSave = (Button) findViewById(R.id.btnSave);
		mBtnUpdate = (Button) findViewById(R.id.btnUpdate);
		mBtnDelete = (Button) findViewById(R.id.btnDelete);
		linear = (LinearLayout) findViewById(R.id.LinearUpdateDeleteAccount);

		if (aA.i == 1) {
			mBtnSave.setVisibility(View.GONE);
			linear.setVisibility(View.VISIBLE);

			mTxtTaiKhoan.setText(listAccount.get(aA.vitri).getLoaiTaiKhoan());
			mTxtMoTa.setText(listAccount.get(aA.vitri).getMota());
			mTxtSoTien.setText(String.valueOf(listAccount.get(aA.vitri)
					.getSoTien()));
			mBtnDelete.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					player = MediaPlayer.create(CreateAccount.this,
							R.raw.airland);
					player.start();
					datasource = new ManageFinanceDatasource(CreateAccount.this);
					datasource.Open();
					datasource.DeleteAccount(mTxtTaiKhoan.getText().toString());
					datasource.Close();
					intent = new Intent(CreateAccount.this,
							AccountActivity.class);
					startActivity(intent);
					finish();
				}
			});
			mBtnUpdate.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						TaikhoanEntity taikhoan = new TaikhoanEntity();
						taikhoan.setLoaiTaiKhoan(mTxtTaiKhoan.getText()
								.toString());
						taikhoan.setMota(mTxtMoTa.getText().toString());
						taikhoan1 = listAccount.get(aA.vitri);
						String a = taikhoan1.getLoaiTaiKhoan();
						String b = taikhoan1.getMota();
						long c = taikhoan1.getSoTien();

						taikhoan.setSoTien(Long.parseLong(mTxtSoTien.getText()
								.toString()));
						if (taikhoan.getLoaiTaiKhoan() == null) {
							Toast.makeText(CreateAccount.this,
									"Bạn cần nhập tên tài khoản",
									Toast.LENGTH_LONG).show();
						} else {
							datasource = new ManageFinanceDatasource(
									CreateAccount.this);
							datasource.Open();
							datasource.UpdateAccount(taikhoan, taikhoan1);
							if (!taikhoan.getLoaiTaiKhoan().equals(a)) {
								datasource.ChangeThuChi(
										taikhoan.getLoaiTaiKhoan(), a);
							}

							datasource.Close();
							Toast.makeText(
									CreateAccount.this,
									"Cập nhật thành công tài khoản "
											+ taikhoan.getLoaiTaiKhoan(),
									Toast.LENGTH_SHORT).show();
							player = MediaPlayer.create(CreateAccount.this,
									R.raw.airland);
							player.start();
							intent = new Intent(CreateAccount.this,
									AccountActivity.class);
							startActivity(intent);
							finish();
						}
					} catch (Exception e) {
						Toast.makeText(CreateAccount.this,
								"Bạn cần phải nhập số tiền cho tài khoản",
								Toast.LENGTH_SHORT).show();
					}
				}
			});
		} else {
			mBtnSave.setVisibility(View.VISIBLE);
			linear.setVisibility(View.GONE);
			mBtnSave.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						TaikhoanEntity taikhoan = new TaikhoanEntity();
						taikhoan.setLoaiTaiKhoan(mTxtTaiKhoan.getText()
								.toString());

						taikhoan.setMota(mTxtMoTa.getText().toString());

						taikhoan.setSoTien(Long.parseLong(mTxtSoTien.getText()
								.toString()));

						if (listAccount != null) {
							int j = 0;
							for (; j < listAccount.size(); j++) {
								if (taikhoan.getLoaiTaiKhoan().equals(
										listAccount.get(j).getLoaiTaiKhoan())) {
									Toast.makeText(CreateAccount.this,
											"Tài khoản đã tồn tại",
											Toast.LENGTH_SHORT).show();
									player = MediaPlayer.create(
											CreateAccount.this, R.raw.beep_05);
									player.start();
									break;
								}
							}
							if (j == listAccount.size()) {

								datasource = new ManageFinanceDatasource(
										CreateAccount.this);
								datasource.Open();
								datasource.AddAccount(taikhoan);
								datasource.Close();
								Toast.makeText(
										CreateAccount.this,
										"Thêm thành công tài khoản "
												+ taikhoan.getLoaiTaiKhoan(),
										Toast.LENGTH_SHORT).show();
								player = MediaPlayer.create(CreateAccount.this,
										R.raw.airland);
								player.start();

							}
						} else {
							if (listAccount != null) {
								int j = 0;
								for (; j < listAccount.size(); j++) {
									if (taikhoan.getLoaiTaiKhoan().equals(
											listAccount.get(j)
													.getLoaiTaiKhoan())) {
										Toast.makeText(CreateAccount.this,
												"Tài khoản đã tồn tại",
												Toast.LENGTH_SHORT).show();
										player = MediaPlayer.create(
												CreateAccount.this,
												R.raw.beep_05);
										player.start();
										break;
									}
								}
								if (j == listAccount.size()) {
									datasource = new ManageFinanceDatasource(
											CreateAccount.this);
									datasource.Open();
									datasource.AddAccount(taikhoan);
									datasource.Close();
									player = MediaPlayer.create(
											CreateAccount.this, R.raw.airland);
									player.start();
									Toast.makeText(
											CreateAccount.this,
											"Thêm thành công tài khoản "
													+ taikhoan
															.getLoaiTaiKhoan(),
											Toast.LENGTH_SHORT).show();
									intent = new Intent(CreateAccount.this,
											AccountActivity.class);
									startActivity(intent);
									finish();
								}
							}

						}
					} catch (Exception e) {
						Toast.makeText(CreateAccount.this,
								"Bạn cần phải nhập số tiền cho tài khoản",
								Toast.LENGTH_SHORT).show();
					}

				}
			});

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_account, menu);
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
