package com.vicken.lilyweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.vicken.lilyweather.service.AutoUpdateService;

/**
 * Created by ccit on 2015/12/11.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context, AutoUpdateService.class);
        context.startService(i);
    }
}
