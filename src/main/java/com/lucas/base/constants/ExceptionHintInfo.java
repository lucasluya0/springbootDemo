package com.lucas.base.constants;

public enum  ExceptionHintInfo {
    NOT_RETURE_TYPE(1000,"对象类型返回错误，请返回 ResponseMsg、ResponseEntity<FileSystemResource>");

    private  final int code;
    private final String msg;

    ExceptionHintInfo(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ExceptionHintInfo constant : ExceptionHintInfo.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }
    public ExceptionHintInfo getTypeByValue(int value) {
        for (ExceptionHintInfo constant : ExceptionHintInfo.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
