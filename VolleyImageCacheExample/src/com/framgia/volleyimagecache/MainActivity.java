package com.framgia.volleyimagecache;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnJsonRequest;
	private Button btnStringRequest;
	private Button btnImageRequest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnJsonRequest = (Button) findViewById(R.id.button_JSonRequest);
		btnStringRequest = (Button) findViewById(R.id.button_StringRequest);
		btnImageRequest = (Button) findViewById(R.id.button_ImageRequest);

		btnJsonRequest.setOnClickListener(this);
		btnStringRequest.setOnClickListener(this);
		btnImageRequest.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_JSonRequest:
			startActivity(new Intent(MainActivity.this, JSonRequestActivity.class));
			break;

		case R.id.button_StringRequest:
			startActivity(new Intent(MainActivity.this, StringRequestActivity.class));
			break;
		case R.id.button_ImageRequest:
			startActivity(new Intent(MainActivity.this, ImageRequestActivity.class));
			break;
		default:
			break;
		}

	}
}
