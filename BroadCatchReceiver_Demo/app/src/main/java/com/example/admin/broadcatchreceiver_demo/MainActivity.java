package com.example.admin.broadcatchreceiver_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView tv_sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv_sms=(TextView)findViewById(R.id.tv_sms);

        IntentFilter filter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");

        BroadcastReceiver receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                showSMS(intent);
            }
        };
        registerReceiver(receiver,filter);
    }
    public void showSMS(Intent intent){
        Bundle bundle=intent.getExtras();

        Object [] objSMS=(Object[]) bundle.get("pdus");
        String sms="";

        for (int i=0;i<objSMS.length;i++){
            SmsMessage smsMsg=SmsMessage.createFromPdu( (byte[]) objSMS[i] );

            String Body=smsMsg.getMessageBody();

            String address=smsMsg.getDisplayOriginatingAddress();
            sms+=address+":\n"+Body+"\n";

        }
        tv_sms.setText(sms);
    }
}
