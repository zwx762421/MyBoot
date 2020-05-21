package com.myself.sbdemo.api.io;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Data
public class UserIo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userId;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String passWord;

    /**
     * 电话
     */
    private String tel;

    /**
     * 性别
     */
    private String sex;

    /**
     * 录入日期
     */
    private String inputDate;
}
