package com.myself.sbdemo.api.user.io;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 根据ID查询入参IO
 */
@Data
public class getByIdIo {

    @NotBlank(message = "用户名不能为空")
    private String userId;
}
