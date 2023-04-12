package com.example.springbootwithpostgressql.response;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class BaseResponse {

    protected int code;
    protected String message;
    protected Map<String, String> data;

    public BaseResponse() {
    }

    public BaseResponse(int code, String message, Map<String, String> data) {
        this.code = code;
        this.message = message;
    }

    public void setSuccess(String msg) {
        this.code = 0;
        this.message = msg;
    }

    public void setSuccess() {
        this.setSuccess("OK");
    }

    public void setResult(int code, String message) {
        this.code = code;
        this.message = message;

    }

    public String baseInfo() {
        return code + "|" + message;
    }
}
