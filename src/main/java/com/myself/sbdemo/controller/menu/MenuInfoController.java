package com.myself.sbdemo.controller.menu;

import com.myself.sbdemo.api.user.io.getByIdIo;
import com.myself.sbdemo.service.MenuInfoService;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menuInfo")
public class MenuInfoController {
    @Autowired
    private MenuInfoService menuInfoService;

    /**
     * 根据权限获取菜单
     * @param getByIdIo
     */
    @RequestMapping("/getMenuByCondition")
    MyselfJSONResult getMenuByCondition (@RequestBody getByIdIo getByIdIo){
        return menuInfoService.getMenuByCondition(getByIdIo);
    }
}
