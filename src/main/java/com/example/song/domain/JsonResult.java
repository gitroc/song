package com.example.song.domain;

import com.alibaba.fastjson.JSON;
import com.example.song.constant.ResultCode;

public class JsonResult {
    private String code;
    private String message;
    private Object result;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");

    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public JsonResult(ResultCode code, String message, Object result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public String getCode() {
        return code;
    }
    public void setCode(ResultCode code) {
        this.code = code.val();
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
