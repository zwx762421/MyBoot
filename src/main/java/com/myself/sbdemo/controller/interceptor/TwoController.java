package com.myself.sbdemo.controller.interceptor;

import com.myself.sbdemo.pojo.example.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:AwakeningCode
 * @Date: Created in 9:33 2018\3\17 0017
 */
@Controller
@RequestMapping("two")
public class TwoController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "myself");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map) {

        SysUser user = new SysUser();
        user.setAge(18);
        user.setName("manager");

        map.addAttribute("user", user);


        List<SysUser> userList = new ArrayList<>();
        userList.add(user);


        map.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postform(SysUser user) {
        System.out.println(user.getName());
        return "redirect:/th/test";
    }

}
