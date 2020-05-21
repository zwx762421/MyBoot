package com.myself.sbdemo.common;

import com.myself.sbdemo.mapper.UserInfoMapper;
import com.myself.sbdemo.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserInfoCommonService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public int insert(UserPojo userPojo){
        userPojo.setInputDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        return userInfoMapper.insert(userPojo);

    }
}
