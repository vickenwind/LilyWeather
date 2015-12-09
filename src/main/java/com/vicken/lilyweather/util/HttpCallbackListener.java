package com.vicken.lilyweather.util;

/**
 * Created by ccit on 2015/12/9.
 */
public interface HttpCallbackListener {

    void onFinish(String response);
    void onError(Exception e);
}
