package com.myself.sbdemo.mapper.menu;

import com.myself.sbdemo.api.menu.vo.MenuInfoVo;
import com.myself.sbdemo.pojo.menu.MenuInfoPojo;
import com.myself.sbdemo.pojo.user.UserInfoPojo;
import com.myself.sbdemo.util.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuInfoMapper extends MyMapper<MenuInfoPojo> {
    /**
     * 根据用户的相关权限查询菜单
     * @param userInfoPojo
     * @return
     */
    List<MenuInfoVo> queryFirstMenuByCondition(UserInfoPojo userInfoPojo);
}