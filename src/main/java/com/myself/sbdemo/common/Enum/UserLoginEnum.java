package com.myself.sbdemo.common.Enum;

/**
 * 用户登录枚举
 */
public enum UserLoginEnum {
    /**
     * code+msg
     */
    ERROR_USER_ID("01","用户名不存在！"),
    ERROR_PASSWORD("02","用户名或密码错误！"),
    LOGIN_SUCCESS("03","登陆成功！"),
    ;

    private String code;
    private String msg;
    UserLoginEnum(String code, String msg){
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
