package com.vicken.lilyweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import com.vicken.lilyweather.receiver.AutoUpdateReceiver;
import com.vicken.lilyweather.util.HttpCallbackListener;
import com.vicken.lilyweather.util.HttpUtil;
import com.vicken.lilyweather.util.Utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
* Created by ccit on 2015/12/11.
        */
public class AutoUpdateService extends Service {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY ="823880ad9663bfc13c34838b32567023";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                updateWeather();
            }

        }).start();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 8 * 60 * 60 * 1000; // 这是8小时的毫秒数
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this, AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }

    private void updateWeather(){
        SharedPreferences  preferences= PreferenceManager.getDefaultSharedPreferences(this);
        String weatherName= preferences.getString("weather_name","");
        String url ="http://op.juhe.cn/onebox/weather/query";//请求接口地址
        Map<String, Object> params = new HashMap<String, Object>();//请求参数
        params.put("cityname",weatherName);//要查询的城市，如：温州、上海、北京
        params.put("key", APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "json");//返回数据的格式,xml或json，默认json
        url = url+"?"+urlencode(params);
        HttpUtil.sendHttpRequest(url, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Utility.handleWeatherResponse(AutoUpdateService.this,response.toString());
            }

            @Override
            public void onError(Exception e) {

                e.printStackTrace();
            }
        });

    }
    public static String urlencode(Map<String, ?> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ?> i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
