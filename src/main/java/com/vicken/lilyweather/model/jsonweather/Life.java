package com.vicken.lilyweather.model.jsonweather;

/**
 * Created by ccit on 2015/12/4.
 */
public class Life {

    private String date;
    private infos info;

    @Override
    public String toString() {
        return "Life{" +
                "date='" + date + '\'' +
                ", info=" + info +
                '}';
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public infos getInfo() {
        return info;
    }

    public void setInfo(infos info) {
        this.info = info;
    }
}
