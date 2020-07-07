package com.myself.sbdemo.service;

import com.myself.sbdemo.api.user.io.getByIdIo;
import com.myself.sbdemo.util.MyselfJSONResult;

public interface MenuInfoService {

    /**
     * 根据用户权限展示一级菜单
     * @param getByIdIo
     * @return
     * @Author ZhangWeixin
     */
    MyselfJSONResult getMenuByCondition(getByIdIo getByIdIo);
}
