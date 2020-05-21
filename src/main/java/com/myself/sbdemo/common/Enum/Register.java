package com.myself.sbdemo.common.Enum;

public enum Register {

    /**
     * code+msg
     */
    REGISTER_SUCCESS("01","注册成功"),
    REGISTER_FAILED("02","注册失败"),
    ;

    private String code;
    private String msg;
    Register(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
