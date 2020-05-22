package com.myself.sbdemo.api.user.io;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用户入参IO
 */
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

    /**
     * Email
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 姓名
     */
    private String name;

    /**
     *  用户类型
     */
    private String userType;

}
