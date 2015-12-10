package com.vicken.lilyweather.model.jsonmodel;

import java.util.List;

/**
 * Created by ccit on 2015/12/10.
 */
public class Address {

    private String reason;
    private List<AddressInfo> result;

    @Override
    public String toString() {
        return "Address{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<AddressInfo> getResult() {
        return result;
    }

    public void setResult(List<AddressInfo> result) {
        this.result = result;
    }
    //    private
}
