package com.myself.sbdemo.service;

import com.myself.sbdemo.pojo.SysUser;

import java.util.List;

/**
 * @Author:AwakeningCode
 * @Date: Created in 17:33 2018\3\16 0016
 */
public interface SysUserService {

    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(String id);

    List<SysUser> queryUserListPaged(SysUser user, Integer page, int pageSize);

    SysUser queryUserByIdCustom(String id);

    void saveUserTransactional(SysUser user);
}
