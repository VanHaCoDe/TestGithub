package gstudingandroidproject.md5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("error","error");

        TextView tv_md5=(TextView)findViewById(R.id.td_tv_md5);

        String input = Integer.toBinaryString(111) ;


        tv_md5.setText(input);
    }
}
