package bkap.android.managefinance.pro;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import bkap.android.managefinance.adapter.AccountAdapter;
import bkap.android.managefinance.database.ManageFinanceDatasource;
import bkap.android.managefinance.entity.TaikhoanEntity;

import com.example.managefinance.pro.R;

public class AccountActivity extends ActionBarActivity {
	Intent intent;
	private ArrayList<TaikhoanEntity> listAccount = new ArrayList<TaikhoanEntity>();
	private ListView mListViewAccount;
	private TextView mLbSoTien;
	public static int i = 0;// Xác định trạng thái muốn tạo tài khoản mới hay
							// muốn sửa xóa tài khoản.
	public static int vitri = 0;
	private long tongTien = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);

		ManageFinanceDatasource datasource = new ManageFinanceDatasource(this);
		datasource.Open();

		listAccount = datasource.getAccount();
		datasource.Close();

		if (listAccount != null) {

			for (int j = 0; j < listAccount.size(); j++) {
				tongTien += listAccount.get(j).getSoTien();
			}

			mListViewAccount = (ListView) findViewById(R.id.listAccount);
			AccountAdapter adapter = new AccountAdapter(AccountActivity.this,
					R.layout.item_account, listAccount);
			mListViewAccount.setAdapter(adapter);
		}

		mLbSoTien = (TextView) findViewById(R.id.lbAmountMoney);
		mLbSoTien.setText("" + tongTien);

		mListViewAccount.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				intent = new Intent(AccountActivity.this, CreateAccount.class);
				startActivity(intent);
				i = 1;
				vitri = position;
			}
		});

		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("ACCOUNT");
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.account, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_account:
			intent = new Intent(AccountActivity.this, CreateAccount.class);
			startActivity(intent);
			finish();
			i = 0;
			break;
		case R.id.moveExpense:
			intent = new Intent(AccountActivity.this, ExpenseActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.moveIncome:
			intent = new Intent(AccountActivity.this, IncomeActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.moveReport:
			intent = new Intent(AccountActivity.this, ReportActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.moveSetting:
			intent = new Intent(AccountActivity.this, SettingActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
