package com.vicken.lilyweather.model.jsonweather;

import java.util.Arrays;

/**
 * Created by ccit on 2015/12/4.
 */
public class Info {


    private String[] day;
    private String[] night;

    private String[] dawn;

    @Override
    public String toString() {
        return "Info{" +
                "day=" + Arrays.toString(day) +
                ", night=" + Arrays.toString(night) +
                ", dawn=" + Arrays.toString(dawn) +
                '}';
    }

    public String[] getDay() {
        return day;
    }

    public void setDay(String[] day) {
        this.day = day;
    }

    public String[] getNight() {
        return night;
    }

    public void setNight(String[] night) {
        this.night = night;
    }

    public String[] getDawn() {
        return dawn;
    }

    public void setDawn(String[] dawn) {
        this.dawn = dawn;
    }
}
