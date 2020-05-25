package com.myself.sbdemo.controller.user;

import com.myself.sbdemo.api.user.io.LoginIo;
import com.myself.sbdemo.api.user.io.UserIo;
import com.myself.sbdemo.service.UserInfoService;
import com.myself.sbdemo.util.MyselfJSONResult;
import com.sun.management.VMOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户注册
     * @param userIo
     */
    @RequestMapping("/userAdd")
    MyselfJSONResult userAdd(@RequestBody UserIo userIo){
        return userInfoService.userAdd(userIo);
    }

    /**
     * 用户登录
     * @param loginIo
     */
    @RequestMapping("/userLogin")
    MyselfJSONResult userLogin(@RequestBody LoginIo loginIo){
        return userInfoService.userLogin(loginIo);
    }
}
