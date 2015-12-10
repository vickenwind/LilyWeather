package com.vicken.lilyweather.model.jsonweather;

import java.util.Arrays;

/**
 * Created by ccit on 2015/12/8.
 */
public class infos {


        private String[] chuanyi;
        private String[] ganmao;
        private String[] kongtiao;
        private String[] wuran;
        private String[] xiche;
        private String[] yundong;

    public String[] getGanmao() {
        return ganmao;
    }

    public void setGanmao(String[] ganmao) {
        this.ganmao = ganmao;
    }

    public String[] getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(String[] kongtiao) {
        this.kongtiao = kongtiao;
    }

    public String[] getWuran() {
        return wuran;
    }

    public void setWuran(String[] wuran) {
        this.wuran = wuran;
    }

    public String[] getXiche() {
        return xiche;
    }

    public void setXiche(String[] xiche) {
        this.xiche = xiche;
    }

    public String[] getYundong() {
        return yundong;
    }

    public void setYundong(String[] yundong) {
        this.yundong = yundong;
    }

    public String[] getZiwaixian() {
        return ziwaixian;
    }

    public void setZiwaixian(String[] ziwaixian) {
        this.ziwaixian = ziwaixian;
    }

    public String[] getChuanyi() {

        return chuanyi;
    }

    public void setChuanyi(String[] chuanyi) {
        this.chuanyi = chuanyi;
    }

    @Override
    public String toString() {
        return "infos{" +
                "chuanyi=" + Arrays.toString(chuanyi) +
                ", ganmao=" + Arrays.toString(ganmao) +
                ", kongtiao=" + Arrays.toString(kongtiao) +
                ", wuran=" + Arrays.toString(wuran) +
                ", xiche=" + Arrays.toString(xiche) +
                ", yundong=" + Arrays.toString(yundong) +
                ", ziwaixian=" + Arrays.toString(ziwaixian) +
                '}';
    }

    private String[] ziwaixian;

    }


