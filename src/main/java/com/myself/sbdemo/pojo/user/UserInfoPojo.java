package com.myself.sbdemo.pojo.user;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 用户pojo
 */
@Table(name = "USER_INFO")
@Data
public class UserInfoPojo {

    /**
     * 用户名
     */
    @Id
    private String userId;


    /**
     * 密码
     */
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
    private String email;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户类别
     */
    private String userType;
}
