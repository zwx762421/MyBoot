package com.myself.sbdemo.api.user.io;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户登录入参IO
 */
@Data
public class LoginIo {

    @NotBlank(message = "用户名不能为空")
    private String userId;

    @NotBlank(message = "密码不能为空")
    private String passWord;

    private String token;
}
