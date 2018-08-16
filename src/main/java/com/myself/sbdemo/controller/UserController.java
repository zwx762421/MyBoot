package com.myself.sbdemo.controller;

import com.myself.sbdemo.pojo.User;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author:AwakeningCode
 * @Date: Created in 11:14 2018\3\15 0015
 */
//@Controller
@RestController
@RequestMapping("/user")
public class UserController{
    @RequestMapping("/getuser")
    //@ResponseBody //返回类型定义为json字符串为主
    public User getUser(){
        User u  = new User();
        u.setName("myself2");
        u.setPassword("myself2");
        u.setAge(18);
        u.setBirthday(new Date());
//      u.setDesc(null);
        return u;
    }

    @RequestMapping("/get_user_json")
    //@ResponseBody //返回类型定义为json字符串为主
    public MyselfJSONResult getUserJSON(){
        User u  = new User();
        u.setName("myself");
        u.setPassword("myself2");
        u.setAge(20);
        u.setBirthday(new Date());
//      u.setDesc(null);
        //200状态码
        return MyselfJSONResult.ok(u);
    }
}
