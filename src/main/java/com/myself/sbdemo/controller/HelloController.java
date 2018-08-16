package com.myself.sbdemo.controller;

import com.myself.sbdemo.pojo.Resource;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller层
 * @RestController：注解为Controller层
 * @Author:AwakeningCode
 * @Date: Created in 10:55 2018\3\15 0015
 */
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello(){
        return "hello springboot!";
    }

    @RequestMapping("/getResource")
    public MyselfJSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return MyselfJSONResult.ok(bean);
    }

}
