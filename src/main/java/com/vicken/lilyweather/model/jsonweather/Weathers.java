package com.vicken.lilyweather.model.jsonweather;

/**
 * Created by ccit on 2015/12/4.
 */
public class Weathers {

    private String temperature;//温度

    private String humidity;//湿度

    private String info;//信息

    private String img;

    @Override
    public String toString() {
        return "Weathers{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", info='" + info + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {

        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
