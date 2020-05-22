package com.myself.sbdemo.service.impl.user;

import com.myself.sbdemo.api.io.UserIo;
import com.myself.sbdemo.common.Enum.Register;
import com.myself.sbdemo.common.user.UserInfoCommonService;
import com.myself.sbdemo.config.EmptyChecker;
import com.myself.sbdemo.pojo.user.UserInfoPojo;
import com.myself.sbdemo.service.UserInfoService;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoCommonService userInfoCommonService;
    @Autowired
    private EmptyChecker emptyChecker;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MyselfJSONResult userAdd(UserIo userIo) {
        UserInfoPojo userInfoPojo = new UserInfoPojo();
        BeanUtils.copyProperties(userIo, userInfoPojo);
        log.info("注册信息：{}", userInfoPojo);
        //第一步：校验用户名是否存在重复
        if(!emptyChecker.isEmpty(userInfoCommonService.getById(userIo.getUserId()))){
            return MyselfJSONResult.errorMsg("用户名已经注册过");
        }
        //第二步：检验邮箱格式是否正确
        String email = userIo.getEmail();
        if (!email.contains("@")){
            return MyselfJSONResult.errorMsg("邮箱格式不正确");
        }
        //第三步：插入操作
        try{
            userInfoCommonService.insert(userInfoPojo);
        }catch(Exception e){
            e.printStackTrace();
            return MyselfJSONResult.errorMsg(Register.REGISTER_FAILED.getMsg());
        }
        return MyselfJSONResult.ok(Register.REGISTER_SUCCESS.getMsg());
    }
}
