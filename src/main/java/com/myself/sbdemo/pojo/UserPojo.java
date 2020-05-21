package com.myself.sbdemo.pojo;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "USER_INFO")
@Data
public class UserPojo {

    private String userId;

    private String passWord;

    private String tel;

    private String sex;

    private String inputDate;
}
