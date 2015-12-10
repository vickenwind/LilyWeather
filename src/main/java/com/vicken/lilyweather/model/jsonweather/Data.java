package com.vicken.lilyweather.model.jsonweather;

import java.util.List;

/**
 * Created by ccit on 2015/12/4.
 */
public class Data {

    private Realtime realtime;
    private Life life;
    private List<Weather> weather;
    private Pm25 pm25;
    private String date;

    @Override
    public String toString() {
        return "Data{" +
                "realtime=" + realtime +
                ", life=" + life +
                ", weather=" + weather +
                ", pm25=" + pm25 +
                ", date='" + date + '\'' +
                ", isForeign='" + isForeign + '\'' +
                '}';
    }

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }

    public Life getLife() {
        return life;
    }

    public void setLife(Life life) {
        this.life = life;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Pm25 getPm25() {
        return pm25;
    }

    public void setPm25(Pm25 pm25) {
        this.pm25 = pm25;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }

    private String isForeign;

}
