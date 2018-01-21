package bkap.android.managefinance.pro;

import com.example.managefinance.pro.R;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ReportActivity extends ActionBarActivity {
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("REPORT");
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.color_blue_light));

		/**
		 * Gọi Fragment hiển thị trên Activity
		 */
		FragmentTransaction tran = getSupportFragmentManager()
				.beginTransaction();
		Fragment fragment = new FragmentChart();
		tran.add(R.id.report, fragment);
		tran.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
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
			intent = new Intent(ReportActivity.this, AccountActivity.class);
			startActivity(intent);
			break;
		case R.id.moveExpense:
			intent = new Intent(ReportActivity.this, ExpenseActivity.class);
			startActivity(intent);
			break;
		case R.id.moveIncome:
			intent = new Intent(ReportActivity.this, IncomeActivity.class);
			startActivity(intent);
			break;
		case R.id.moveReport:
			intent = new Intent(ReportActivity.this, ReportActivity.class);
			startActivity(intent);
			break;
		case R.id.moveSetting:
			intent = new Intent(ReportActivity.this, SettingActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
