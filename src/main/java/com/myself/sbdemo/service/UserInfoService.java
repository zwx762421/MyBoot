package com.myself.sbdemo.service;

import com.myself.sbdemo.api.io.UserIo;
import com.myself.sbdemo.util.MyselfJSONResult;

public interface UserInfoService{

     /**
      * 用户注册
      * @param userIo
      * @return
      * @Author ZhangWeixin
      */
     MyselfJSONResult userAdd(UserIo userIo);
}
