package com.lucas.base.utils;

public class BaseUtil {

    public static Object isResponseMsg(Object o){
        if(o instanceof ResponseMsg){
            return o;
        }else {
            return "请返回 ResponseMsg 对象类型";
        }
    }
}
