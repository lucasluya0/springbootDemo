package com.lucas.base.utils;

import com.lucas.base.constants.ResponseCode;
import com.lucas.base.constants.ReturnType;

import java.util.HashMap;
import java.util.Map;

public class ResponseMsg {

    private int code;//返回状态码
    private String hintInformation;//提示信息
    private Map<String,Object> responseData = new HashMap<String,Object>(); //数据
    private ReturnType returnType = ReturnType.JSON_DATA; //返回数据类型

    public static ResponseMsg success(){
        ResponseMsg msg = new ResponseMsg();
        msg.setCode(ResponseCode.SUCCESS_CODE);
        msg.setHintInformation("处理成功");
        return msg;
    }
    public ResponseMsg addData(String str,Object obj){
        this.getResponseData().put(str, obj);
        return this;
    }
    public static ResponseMsg fail(){
        ResponseMsg msg = new ResponseMsg();
        msg.setCode(ResponseCode.FAILURE_CODE);
        msg.setHintInformation("处理失败");
        return msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHintInformation() {
        return hintInformation;
    }

    public void setHintInformation(String hintInformation) {
        this.hintInformation = hintInformation;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType;
    }
}