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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import bkap.android.managefinance.adapter.AccountAdapter;
import bkap.android.managefinance.adapter.ExpensesAdapter;
import bkap.android.managefinance.database.ManageFinanceDatasource;
import bkap.android.managefinance.entity.ThuchiEntity;

import com.example.managefinance.pro.R;

public class ExpenseActivity extends ActionBarActivity {
	Intent intent;
	private ListView mListViewExpense;
	private ArrayList<ThuchiEntity> listThuChi = new ArrayList<ThuchiEntity>();
	public static int visibilityExpense = 0;
	public static int vitriExpense = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expense);

		ManageFinanceDatasource datasource = new ManageFinanceDatasource(this);
		datasource.Open();

		listThuChi = datasource.getExpense();
		datasource.Close();

		if (listThuChi != null) {
			for (int i = 0; i < listThuChi.size(); i++) {
				Log.e("" + (i + 1), "" + listThuChi.get(i).getLoaiTaiKhoan());
			}

			mListViewExpense = (ListView) findViewById(R.id.listExpense);
			ExpensesAdapter adapter = new ExpensesAdapter(ExpenseActivity.this,
					R.layout.item_account, listThuChi);
			mListViewExpense.setAdapter(adapter);
		}

		mListViewExpense.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				intent = new Intent(ExpenseActivity.this, CreateExpenses.class);
				startActivity(intent);
				finish();
				visibilityExpense = 1;
				vitriExpense = position;
			}
		});

		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("EXPENSES");
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expense, menu);
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
			intent = new Intent(ExpenseActivity.this, AccountActivity.class);
			startActivity(intent);
			break;
		case R.id.moveExpense:
			intent = new Intent(ExpenseActivity.this, ExpenseActivity.class);
			startActivity(intent);
			break;
		case R.id.moveIncome:
			intent = new Intent(ExpenseActivity.this, IncomeActivity.class);
			startActivity(intent);
			break;
		case R.id.moveReport:
			intent = new Intent(ExpenseActivity.this, ReportActivity.class);
			startActivity(intent);
			break;
		case R.id.action_expense:
			intent = new Intent(ExpenseActivity.this, CreateExpenses.class);
			startActivity(intent);
			visibilityExpense = 0;
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
