package com.myself.sbdemo.service;

import com.myself.sbdemo.api.user.io.LoginIo;
import com.myself.sbdemo.api.user.io.UserIo;
import com.myself.sbdemo.util.MyselfJSONResult;

public interface UserInfoService{

     /**
      * 用户注册
      * @param userIo
      * @return
      * @Author ZhangWeixin
      */
     MyselfJSONResult userAdd(UserIo userIo);

     /**
      * 用户登录
      * @param loginIo
      * @return
      * @Author ZhangWeixin
      */
     MyselfJSONResult userLogin(LoginIo loginIo);
}
