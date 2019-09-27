package com.example.smartwatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReciever extends BroadcastReceiver {
    public static  final String SMS_BUNDLE ="pdus";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null)
        {
            Object[] sms = (Object[])intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            for (int i =0;i<sms.length;i++)
            {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();
                String address = smsMessage.getOriginatingAddress();

                smsMessageStr += "SMS From: "+address+"\n";
                smsMessageStr += smsBody + "\n";
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();

            MessageActivity inst = MessageActivity.instance();
            inst.updateList(smsMessageStr);
        }
    }
}
