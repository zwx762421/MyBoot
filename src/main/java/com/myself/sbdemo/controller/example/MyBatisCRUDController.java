package com.myself.sbdemo.controller.example;

import com.myself.sbdemo.pojo.example.SysUser;
import com.myself.sbdemo.service.SysUserService;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author:AwakeningCode
 * @Date: Created in 17:41 2018\3\16 0016
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveuser")
    public MyselfJSONResult saveUser() throws Exception{
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setAge(18);
        user.setName("myself" + new Date());
        userService.saveUser(user);
        return MyselfJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateuser")
    public MyselfJSONResult updateUser(){
        SysUser user = new SysUser();
        user.setId("0000001");
        user.setName("bbbb");
        user.setAge(20);

        userService.updateUser(user);

        return MyselfJSONResult.ok("更新成功");
    }

    @RequestMapping("/deleteUser")
    public MyselfJSONResult deleteUser(String userId){
        userService.deleteUser(userId);
        return MyselfJSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserListPaged")
    public MyselfJSONResult queryUserListPaged(Integer page){
        if (page == null){
            page = 1;
        }
        int pageSize = 10;
        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user,page,pageSize);
        return MyselfJSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public MyselfJSONResult queryUserByIdCustom(String id){

        return MyselfJSONResult.ok(userService.queryUserByIdCustom(id));

    }

    @RequestMapping("/saveUserTransactional")
    public MyselfJSONResult saveUserTransactional(){
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setAge(18);
        user.setName("myself" + new Date());
        userService.saveUserTransactional(user);
        return MyselfJSONResult.ok("保存成功");
    }

}
