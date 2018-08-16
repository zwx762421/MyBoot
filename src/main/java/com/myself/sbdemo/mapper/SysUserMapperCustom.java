package com.myself.sbdemo.mapper;

import com.myself.sbdemo.pojo.SysUser;
import com.myself.sbdemo.util.MyMapper;

import java.util.List;

public interface SysUserMapperCustom extends MyMapper<SysUser> {

    List<SysUser> queryUserSimplyInfoById(String id);
}