package bkap.android.managefinance.pro;

import com.example.managefinance.pro.R;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SettingActivity extends ActionBarActivity {
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("SETTINGS");
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
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
			intent = new Intent(SettingActivity.this, AccountActivity.class);
			startActivity(intent);
			break;
		case R.id.moveExpense:
			intent = new Intent(SettingActivity.this, ExpenseActivity.class);
			startActivity(intent);
			break;
		case R.id.moveIncome:
			intent = new Intent(SettingActivity.this, IncomeActivity.class);
			startActivity(intent);
			break;
		case R.id.moveReport:
			intent = new Intent(SettingActivity.this, ReportActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
