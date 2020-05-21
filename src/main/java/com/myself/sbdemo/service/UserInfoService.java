package com.myself.sbdemo.service;

import com.myself.sbdemo.api.io.UserIo;
import com.myself.sbdemo.util.MyselfJSONResult;

public interface UserInfoService {

     MyselfJSONResult userAdd(UserIo userIo);
}
