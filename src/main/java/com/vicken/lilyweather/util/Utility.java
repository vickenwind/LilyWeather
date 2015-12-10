package com.vicken.lilyweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vicken.lilyweather.db.LilyWeatherDB;
import com.vicken.lilyweather.model.City;
import com.vicken.lilyweather.model.County;
import com.vicken.lilyweather.model.Province;
import com.vicken.lilyweather.model.jsonmodel.Address;
import com.vicken.lilyweather.model.jsonmodel.AddressInfo;

import java.util.List;

/**
 * Created by ccit on 2015/12/9.
 * 使用GSON解析
 */
public class Utility {
    public synchronized static boolean handleProvincesResponse(LilyWeatherDB lilyWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            Gson gson=new Gson();
            Address adress= gson.fromJson(response,new TypeToken<Address>(){}.getType());
            List<AddressInfo> addressInfo=adress.getResult();
            if(addressInfo.size()>0){
                for(AddressInfo info:addressInfo){
                    Province province=new Province();
                    province.setProvinceName(info.getName());
                    province.setProvinceCode(info.getId());
                    lilyWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的省级数据
     */
//    public synchronized static boolean handleProvincesResponse(LilyWeatherDB lilyWeatherDB, String response) {
//        if (!TextUtils.isEmpty(response)) {
//            String[] allProvinces = response.split(",");
//            if (allProvinces != null && allProvinces.length > 0) {
//                for (String p : allProvinces) {
//                    String[] array = p.split("\\|");
//                    Province province = new Province();
//                    province.setProvinceCode(array[0]);
//                    province.setProvinceName(array[1]);
//// 将解析出来的数据存储到Province表
//                    lilyWeatherDB.saveProvince(province);
//                }
//                return true;
//            }
//        }
//        return false;
//    }




    /**
     * 解析和处理服务器返回的市级数据
     */

    public static boolean handleCitiesResponse(LilyWeatherDB lilyWeatherDB,String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            Gson gson=new Gson();
            Address adress=gson.fromJson(response,new TypeToken<Address>(){}.getType());
            List<AddressInfo> addressinfo=adress.getResult();
            if(addressinfo.size()>0){
                for(AddressInfo info:addressinfo){
                    City city=new City();
                    city.setCityCode(info.getId());
                    city.setCityName(info.getName());
                    city.setProvinceId(provinceId);
                    lilyWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }
//    public static boolean handleCitiesResponse(LilyWeatherDB lilyWeatherDB,String response, int provinceId) {
//        if (!TextUtils.isEmpty(response)) {
//            String[] allCities = response.split(",");
//            if (allCities != null && allCities.length > 0) {
//                for (String c : allCities) {
//                    String[] array = c.split("\\|");
//                    City city = new City();
//                    city.setCityCode(array[0]);
//                    city.setCityName(array[1]);
//                    city.setProvinceId(provinceId);
//// 将解析出来的数据存储到City表
//                    lilyWeatherDB.saveCity(city);
//                }
//                return true;
//            }
//        }
//        return false;
//    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(LilyWeatherDB lilyWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            Gson  gson=new Gson();
            Address  adress=gson.fromJson(response,new TypeToken<Address>(){}.getType());
            List<AddressInfo> addressInfos=adress.getResult();
            if(addressInfos.size()>0){
                for(AddressInfo info:addressInfos){
                    County county=new County();
                    county.setCountyCode(info.getId());
                    county.setCountyName(info.getFullName());
                    county.setCityId(cityId);
                    lilyWeatherDB.saveCounty(county);
                }
                return true;
            }

        }
        return false;
    }
//    public static boolean handleCountiesResponse(LilyWeatherDB lilyWeatherDB, String response, int cityId) {
//        if (!TextUtils.isEmpty(response)) {
//            String[] allCounties = response.split(",");
//            if (allCounties != null && allCounties.length > 0) {
//                for (String c : allCounties) {
//                    String[] array = c.split("\\|");
//                    County county = new County();
//                    county.setCountyCode(array[0]);
//                    county.setCountyName(array[1]);
//                    county.setCityId(cityId);
//// 将解析出来的数据存储到County表
//                    lilyWeatherDB.saveCounty(county);
//                }
//                return true;
//            }
//        }
//        return false;
//    }

}
