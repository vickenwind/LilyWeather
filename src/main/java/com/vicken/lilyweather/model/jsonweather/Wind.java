package com.vicken.lilyweather.model.jsonweather;

/**
 * Created by Vicken on 2015/12/4.
 */
public class Wind {

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "direct='" + direct + '\'' +
                ", power='" + power + '\'' +
                ", offset='" + offset + '\'' +
                ", windspeed='" + windspeed + '\'' +
                '}';
    }

    public String getDirect() {

        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    private String direct;//风向
    private String power;//风力

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    private String offset;
    private String windspeed;//风速
    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }



}
