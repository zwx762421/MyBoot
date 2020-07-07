package com.myself.sbdemo.common.menu;

import com.myself.sbdemo.api.menu.vo.MenuInfoVo;
import com.myself.sbdemo.mapper.menu.MenuInfoMapper;
import com.myself.sbdemo.pojo.menu.MenuInfoPojo;
import com.myself.sbdemo.pojo.user.UserInfoPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MenuInfoCommonService {

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    /**
     * 根据用户权限查询菜单
     * @param userInfoPojo
     * @return list
     * @Author ZhangWeixin
     */
    public List<MenuInfoVo> getFirstMenuByCondition(UserInfoPojo userInfoPojo){
        return menuInfoMapper.queryFirstMenuByCondition(userInfoPojo);
    }
}
