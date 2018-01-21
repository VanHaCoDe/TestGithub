package com.libreteam.levanha.vietnamtouristmap.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.libreteam.levanha.vietnamtouristmap.Interface.IloadDataServices;
import com.libreteam.levanha.vietnamtouristmap.R;
import com.libreteam.levanha.vietnamtouristmap.webService.DataList;
import com.libreteam.levanha.vietnamtouristmap.webService.DataRequest;
import com.libreteam.levanha.vietnamtouristmap.webService.Datum;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoadActivity extends AppCompatActivity implements IloadDataServices {
    ProgressBar pgbLoad;

    DataRequest dataRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_layout);

        pgbLoad = (ProgressBar) findViewById(R.id.pgb_loading);
        pgbLoad.setVisibility(View.VISIBLE);

        dataRequest = new DataRequest(getApplicationContext(), this);
    }

    @Override
    public void loadData(DataList dataList) {
        Datum datum = new Datum();
        datum.setDataitems(dataList.getData());
        pgbLoad.setVisibility(View.GONE);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
