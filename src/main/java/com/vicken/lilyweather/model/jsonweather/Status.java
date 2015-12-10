package com.vicken.lilyweather.model.jsonweather;

/**
 * Created by ccit on 2015/12/4.
 */
public class Status {

    private String reason;

    @Override
    public String toString() {
        return "Status{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code='" + error_code + '\'' +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    private Result result;

    private String error_code;

}
