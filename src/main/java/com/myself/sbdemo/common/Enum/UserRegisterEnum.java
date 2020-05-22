package com.myself.sbdemo.common.Enum;

/**
 * @Author Zhangweixin
 * 用户注册相关枚举
 */
public enum UserRegisterEnum {

    /**
     * code+msg
     */
    REGISTER_SUCCESS("01","注册成功！"),
    REGISTER_FAILED("02","注册失败！"),
    USER_HAS_REGISTERED("03","用户名已经被注册！"),
    ERROR_EMAIL("04","邮箱格式不正确！"),
    USER_ID_LENGTH_TOO_SHORT("05","用户名不能为空且要大于7个字符！"),
    PASSWORD_MUST_HAS_LITTER("06","密码必须含有字母！"),
    PASSWORD_MUST_HAS_NUMBER("07","密码必须含有数字"),
    PASSWORD_TOO_SHORT("08","密码不能为空且要大于7个字符"),
    ;

    private String code;
    private String msg;
    UserRegisterEnum(String code, String msg){
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
