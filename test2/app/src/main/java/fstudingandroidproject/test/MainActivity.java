package fstudingandroidproject.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrTen;
    ArrayAdapter<String> arrayAdapter;
    ListView lvTen;
    EditText txtTen;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btnLuu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                XuLyChon();
            }

            private void XuLyChon() {
                String ten = txtTen.getText().toString();
                arrayAdapter.notifyDataSetChanged();
                arrTen.add(ten);
                txtTen.setText("");
                txtTen.requestFocus();
            }
        });
    }

    private void addControl() {

        btnLuu = (Button) findViewById(R.id.btnLuuDuLieu);
        arrTen = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, arrTen);
        lvTen = (ListView) findViewById(R.id.lvTen);
        lvTen.setAdapter(arrayAdapter);

    }
}
