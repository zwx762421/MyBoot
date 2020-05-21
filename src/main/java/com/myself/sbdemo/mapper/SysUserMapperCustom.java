package com.myself.sbdemo.mapper;

import com.myself.sbdemo.pojo.SysUser;
import com.myself.sbdemo.util.MyMapper;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysUserMapperCustom extends MyMapper<SysUser> {

    List<SysUser> queryUserSimplyInfoById(String id);
}