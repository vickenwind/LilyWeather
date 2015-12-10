package com.vicken.lilyweather.model.jsonweather;

/**
 * Created by ccit on 2015/12/4.
 */
public class Weather {
    private String date;

    private String week;
    private String nongli;
    private Info info;


    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", nongli='" + nongli + '\'' +
                ", info=" + info +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNongli() {
        return nongli;
    }

    public void setNongli(String nongli) {
        this.nongli = nongli;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
