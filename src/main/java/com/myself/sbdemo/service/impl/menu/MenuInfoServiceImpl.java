package com.myself.sbdemo.service.impl.menu;

import com.myself.sbdemo.api.user.io.getByIdIo;
import com.myself.sbdemo.common.menu.MenuInfoCommonService;
import com.myself.sbdemo.common.user.UserInfoCommonService;
import com.myself.sbdemo.pojo.menu.MenuInfoPojo;
import com.myself.sbdemo.pojo.user.UserInfoPojo;
import com.myself.sbdemo.service.MenuInfoService;
import com.myself.sbdemo.util.EmptyChecker;
import com.myself.sbdemo.util.MyselfJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Zhangweixin
 * 菜单操作 Service
 *
 */
@Service
@Slf4j
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private UserInfoCommonService userInfoCommonService;
    @Autowired
    private MenuInfoCommonService menuInfoCommonService;
    @Autowired
    private EmptyChecker emptyChecker;
    @Override
    public MyselfJSONResult getMenuByCondition(getByIdIo getByIdIo) {
        // 第一步：根据用户Id拿到用户类型
        UserInfoPojo byId = userInfoCommonService.getById(getByIdIo.getUserId());
        if(emptyChecker.isEmpty(byId)){
            return MyselfJSONResult.errorMsg("错误");
        }
        // 第二步：根据userType拿到相对应的菜单
        List firstMenuByCondition = menuInfoCommonService.getFirstMenuByCondition(byId);
        return MyselfJSONResult.ok(firstMenuByCondition);
    }
}
