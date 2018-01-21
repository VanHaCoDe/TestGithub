package bkap.android.managefinance.pro;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import bkap.android.managefinance.adapter.IncomeAdapter;
import bkap.android.managefinance.database.ManageFinanceDatasource;
import bkap.android.managefinance.entity.ThuchiEntity;

import com.example.managefinance.pro.R;

public class IncomeActivity extends ActionBarActivity {

	private Intent intent;
	private ListView mListViewIncome;
	private List<ThuchiEntity> listIncome = new ArrayList<ThuchiEntity>();

	public static int visibilityIncome = 0;
	public static int vitriIncome = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_income);
		/**
		 * lấy dữ liệu từ cơ sở dữ liệu
		 */
		ManageFinanceDatasource datasource = new ManageFinanceDatasource(
				IncomeActivity.this);
		datasource.Open();
		listIncome = datasource.getIncome();
		datasource.Close();
		/**
		 * Hiển thị cơ sở dữ liệu lên list view
		 */
		if (listIncome.size() != 0) {
			mListViewIncome = (ListView) findViewById(R.id.listIncome);
			IncomeAdapter adapter = new IncomeAdapter(IncomeActivity.this,
					R.layout.item_account, listIncome);
			mListViewIncome.setAdapter(adapter);
		}

		/**
		 * Tạo sự kiện khi người sử dụng click vào một item trong listView
		 */
		mListViewIncome.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				visibilityIncome = 1;
				vitriIncome = position;
				intent = new Intent(IncomeActivity.this, CreateIncome.class);
				startActivity(intent);
				finish();
			}
		});

		/**
		 * Điều khiển action bar
		 */
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("INCOME");
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.income, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.moveAccount:
			intent = new Intent(IncomeActivity.this, AccountActivity.class);
			startActivity(intent);
			break;
		case R.id.moveExpense:
			intent = new Intent(IncomeActivity.this, ExpenseActivity.class);
			startActivity(intent);
			break;
		case R.id.moveIncome:
			intent = new Intent(IncomeActivity.this, SettingActivity.class);
			startActivity(intent);
			break;
		case R.id.moveReport:
			intent = new Intent(IncomeActivity.this, ReportActivity.class);
			startActivity(intent);
			break;
		case R.id.action_income:
			intent = new Intent(IncomeActivity.this, CreateIncome.class);
			startActivity(intent);
			visibilityIncome = 0;
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
