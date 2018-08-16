package com.myself.sbdemo.controller;

import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:AwakeningCode
 * @Date: Created in 17:21 2018\3\15 0015
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error(){
        int a = 1 / 0;

        return "error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public MyselfJSONResult getAjaxerror() {

        int a = 1 / 0;

        return MyselfJSONResult.ok();
    }
}
