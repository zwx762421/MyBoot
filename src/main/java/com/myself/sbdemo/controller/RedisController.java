package com.myself.sbdemo.controller;

import com.myself.sbdemo.pojo.SysUser;
import com.myself.sbdemo.util.JsonUtil;
import com.myself.sbdemo.util.MyselfJSONResult;
import com.myself.sbdemo.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:AwakeningCode
 * @Date: Created in 22:38 2018\3\16 0016
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public MyselfJSONResult test(){
        strRedis.opsForValue().set("myself-cache","hello myself");

        SysUser user = new SysUser();
        user.setId("12333");
        user.setName("redis");
        user.setAge(18);

        strRedis.opsForValue().set("json:user", JsonUtil.objectToJson(user));

        SysUser jsonUser = JsonUtil.jsonToPojo(strRedis.opsForValue().get("json:user"),SysUser.class);

        //return MyselfJSONResult.ok(strRedis.opsForValue().get("myself-cache"));
        return MyselfJSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public MyselfJSONResult getJsonList(){
        SysUser u1 = new SysUser();
        u1.setId("567");
        u1.setName("redis01");
        u1.setAge(18);

        SysUser u2 = new SysUser();
        u2.setId("678");
        u2.setName("redis02");
        u2.setAge(19);

        SysUser u3 = new SysUser();
        u3.setId("789");
        u3.setName("redis03");
        u3.setAge(20);

        List<SysUser> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        redis.set("json:info:userlist",JsonUtil.objectToJson(userList),2000);

        String userListJson = redis.get("json:info:userlist");
        List<SysUser> userListBorn = JsonUtil.jsonToList(userListJson,SysUser.class);

        return MyselfJSONResult.ok(userListBorn);
    }

}
