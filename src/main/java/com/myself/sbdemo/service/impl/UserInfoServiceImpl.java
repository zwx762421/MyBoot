package com.myself.sbdemo.service.impl;

import com.myself.sbdemo.api.io.UserIo;
import com.myself.sbdemo.common.Enum.Register;
import com.myself.sbdemo.common.UserInfoCommonService;
import com.myself.sbdemo.pojo.UserPojo;
import com.myself.sbdemo.service.UserInfoService;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoCommonService userInfoCommonService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MyselfJSONResult userAdd(UserIo userIo) {
        UserPojo userPojo = new UserPojo();
        BeanUtils.copyProperties(userIo,userPojo);
        log.info("注册信息：{}",userPojo);
        try{
            userInfoCommonService.insert(userPojo);
        }catch(Exception e){
            e.printStackTrace();
            return MyselfJSONResult.ok(Register.REGISTER_FAILED.getMsg());
        }
        return MyselfJSONResult.ok(Register.REGISTER_SUCCESS.getMsg());
    }
}
