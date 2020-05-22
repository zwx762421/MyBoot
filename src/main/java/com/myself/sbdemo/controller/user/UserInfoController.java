package com.myself.sbdemo.controller.user;

import com.myself.sbdemo.api.io.UserIo;
import com.myself.sbdemo.service.UserInfoService;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/insert")
    MyselfJSONResult insert(@RequestBody UserIo userIo){
        return userInfoService.userAdd(userIo);
    }
}
