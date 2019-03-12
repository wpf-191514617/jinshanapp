package com.minilive.library.entity.http;

/**
 * Created by Administrator on 2018/1/9.
 */

public class BaseResponse {

    private int code;
    private String message;
    private Object resultMap;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultMap() {
        return resultMap;
    }

    public void setResultMap(Object resultMap) {
        this.resultMap = resultMap;
    }
}
