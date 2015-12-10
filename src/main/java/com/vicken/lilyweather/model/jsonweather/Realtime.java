package com.vicken.lilyweather.model.jsonweather;

/**
 * Created by ccit on 2015/12/4.
 */
public class Realtime {

//              city_code": "101210701",
//            "city_name": "温州",     /*城市*/
//            "date": "2014-10-15",  /*日期*/
//            "time": "09:00:00",     /*更新时间*/
//            "week": 3,
//            "moon": "九月廿二",
//            "dataUptime": 1413337811,
    private String city_code;
    private String city_name;
    private String date;
    private String time;
    private String week;
    private String moon;
    private String dataUptime;


    private Weathers weather;
    private Wind wind;

    @Override
    public String toString() {
        return "Realtime{" +
                "city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", week='" + week + '\'' +
                ", moon='" + moon + '\'' +
                ", dataUptime='" + dataUptime + '\'' +
                ", weather=" + weather +
                ", wind=" + wind +
                '}';
    }

    public Weathers getWeather() {
        return weather;
    }

    public void setWeather(Weathers weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public String getDataUptime() {
        return dataUptime;
    }

    public void setDataUptime(String dataUptime) {
        this.dataUptime = dataUptime;
    }
}
