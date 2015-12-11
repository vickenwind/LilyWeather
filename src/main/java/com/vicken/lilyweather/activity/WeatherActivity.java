package com.vicken.lilyweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vicken.lilyweather.R;
import com.vicken.lilyweather.receiver.AutoUpdateReceiver;
import com.vicken.lilyweather.service.AutoUpdateService;
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
public class WeatherActivity extends Activity implements View.OnClickListener {

    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY ="823880ad9663bfc13c34838b32567023";
    private LinearLayout weatherInfoLayout;
    /**
     * 用于显示城市名
     */
    private TextView cityNameText;
    /**
     * 用于显示发布时间
     */
    private TextView publishText;
    /**
     * 用于显示天气描述信息
     */
    private TextView weatherDespText;
    /**
     * 用于显示气温1
     */
    private TextView temp1Text;
    /**
     * 用于显示气温2
     */
    private TextView temp2Text;
    /**
     * 用于显示当前日期
     */
    private TextView currentDateText;
    /**
     * 切换城市按钮
     */
    private Button switchCity;
    /**
     * 更新天气按钮
     */
    private Button refreshWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weather_layout);
        weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
        cityNameText = (TextView) findViewById(R.id.city_name);
        publishText = (TextView) findViewById(R.id.publish_text);
        weatherDespText = (TextView) findViewById(R.id.weather_desp);
        temp1Text = (TextView) findViewById(R.id.temp1);
        temp2Text = (TextView) findViewById(R.id.temp2);
        currentDateText = (TextView) findViewById(R.id.current_date);
        switchCity = (Button) findViewById(R.id.switch_city);
        refreshWeather = (Button) findViewById(R.id.refresh_weather);
        String countyName = getIntent().getStringExtra("county_name");
        if (!TextUtils.isEmpty(countyName)) {
            publishText.setText("同步中......");
            weatherInfoLayout.setVisibility(View.INVISIBLE);
            cityNameText.setVisibility(View.INVISIBLE);
            queryWeatherName(countyName);

        } else {
            // 没有县级代号时就直接显示本地天气
            showWeather();
        }
        switchCity.setOnClickListener(this);
        refreshWeather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.switch_city:
                Intent intent = new Intent(this, ChooseAreaActivity.class);
                intent.putExtra("from_weather_activity", true);
                startActivity(intent);
                finish();
                break;
            case R.id.refresh_weather:
                publishText.setText("同步中......");
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                String weatherName = preferences.getString("weather_name", "");
                if (!TextUtils.isEmpty(weatherName)) {
                    queryWeatherName(weatherName);
                }
                break;
            default:
                break;
        }
    }

    /**
     * 查询县级代号所对应的天气代号。
     */
    private void queryWeatherName(String countyName) {
        String url ="http://op.juhe.cn/onebox/weather/query";//请求接口地址
        Map<String, Object> params = new HashMap<String, Object>();//请求参数
        params.put("cityname",countyName);//要查询的城市，如：温州、上海、北京
        params.put("key", APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "json");//返回数据的格式,xml或json，默认json
//        String address = "http://www.weather.com.cn/data/list3/city" +
//                countyCode + ".xml";
        url = url+"?"+urlencode(params);
        queryFromServer(url);
    }

    /**
     * 查询天气代号所对应的天气。
     */
//    private void queryWeatherInfo(String weatherCode) {
//        String address = "http://www.weather.com.cn/data/cityinfo/" +
//                weatherCode + ".html";
////        queryFromServer(address, "weatherCode");
//    }

    /**
     * 根据传入的地址和类型去向服务器查询天气代号或者天气信息。
     */
    private void queryFromServer(final String address) {
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(final String response) {
//                if ("countyCode".equals(type)) {
//                    if (!TextUtils.isEmpty(response)) {
//// 从服务器返回的数据中解析出天气代号
//                        String[] array = response.split("\\|");
//                        if (array != null && array.length == 2) {
//                            String weatherCode = array[1];
//                            queryWeatherInfo(weatherCode);
//                        }
//                    }
//                } else if ("weatherCode".equals(type)) {
                    // 处理服务器返回的天气信息
                    Utility.handleWeatherResponse(WeatherActivity.this,
                            response);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showWeather();
                        }
                    });
//                }
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        publishText.setText("同步失败");
                    }
                });
            }
        });
    }
    /**
     * 从SharedPreferences文件中读取存储的天气信息，并显示到界面上。
     */
    private void showWeather() {
        SharedPreferences prefs = PreferenceManager.
                getDefaultSharedPreferences(this);
        cityNameText.setText( prefs.getString("city_name", ""));
        temp1Text.setText(prefs.getString("temp1", ""));
        temp2Text.setText(prefs.getString("temp2", ""));
        weatherDespText.setText(prefs.getString("weather_desp", ""));
        publishText.setText("今天" + prefs.getString("publish_time", "") + "发布");
        currentDateText.setText(prefs.getString("current_date", ""));
        weatherInfoLayout.setVisibility(View.VISIBLE);
        cityNameText.setVisibility(View.VISIBLE);
        Intent i=new Intent(this, AutoUpdateService.class);
        startService(i);
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