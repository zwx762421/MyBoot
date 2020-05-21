package com.myself.sbdemo.pojo;

import lombok.Data;

import javax.persistence.*;

@Table(name = "sys_user")
@Data
public class SysUser {
    @Id
    private String id;

    private String name;

    private Integer age;

}