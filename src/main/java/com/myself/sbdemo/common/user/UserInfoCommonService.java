package com.myself.sbdemo.common.user;

import com.myself.sbdemo.mapper.user.UserInfoMapper;
import com.myself.sbdemo.pojo.user.UserInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserInfoCommonService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 新增用户入库
     * @param userInfoPojo
     * @return userInfoPojo
     * @Author ZhangWeixin
     */
    public int insert(UserInfoPojo userInfoPojo){
        userInfoPojo.setInputDate(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        return userInfoMapper.insert(userInfoPojo);
    }

    /**
     * 通过主键查询
     * @param userId
     * @return UserInfoPojo
     * @Author ZhangWeixin
     */
    public UserInfoPojo getById(String userId){
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
