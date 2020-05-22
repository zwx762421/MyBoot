package com.myself.sbdemo.mapper.example;

import com.myself.sbdemo.pojo.example.SysUser;
import com.myself.sbdemo.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysUserMapperCustom extends MyMapper<SysUser> {

    List<SysUser> queryUserSimplyInfoById(String id);
}