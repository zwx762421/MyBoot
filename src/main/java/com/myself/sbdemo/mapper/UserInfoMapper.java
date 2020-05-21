package com.myself.sbdemo.mapper;

import com.myself.sbdemo.pojo.UserPojo;
import com.myself.sbdemo.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper extends MyMapper<UserPojo> {
}
