package com.myself.sbdemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @Author:AwakeningCode
 * @Date: Created in 11:12 2018\3\15 0015
 */
@Data
public class User {

    private String name;

    @JsonIgnore
    private String password;
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a",locale = "zh",timezone = "GMT+8")
    private Date birthday;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;

}
