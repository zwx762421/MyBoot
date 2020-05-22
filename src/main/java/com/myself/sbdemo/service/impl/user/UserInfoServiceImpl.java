package com.myself.sbdemo.service.impl.user;

import com.myself.sbdemo.api.user.io.LoginIo;
import com.myself.sbdemo.api.user.io.UserIo;
import com.myself.sbdemo.common.Enum.UserLoginEnum;
import com.myself.sbdemo.common.Enum.UserRegisterEnum;
import com.myself.sbdemo.common.user.UserInfoCommonService;
import com.myself.sbdemo.util.EmptyChecker;
import com.myself.sbdemo.pojo.user.UserInfoPojo;
import com.myself.sbdemo.service.UserInfoService;
import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Zhangweixin
 * 用户操作 Service
 *
 */
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
        //第一步：用户名、密码校验
        String userId = userIo.getUserId();
        //用户名长度需要大于7个字符
        if(userId.length() < 7){
            return MyselfJSONResult.errorMsg(UserRegisterEnum.USER_ID_LENGTH_TOO_SHORT.getMsg());//用户名不能为空且要大于7个字符
        }
        //密码必须包含数字和字母且长度大于7位
        String passWord = userIo.getPassWord();
        if(passWord.matches("[a-zA-Z]+")){
            return MyselfJSONResult.errorMsg(UserRegisterEnum.PASSWORD_MUST_HAS_NUMBER.getMsg());//密码必须包含数字
        }else if(passWord.matches("[0-9]+")){
            return MyselfJSONResult.errorMsg(UserRegisterEnum.PASSWORD_MUST_HAS_LITTER.getMsg());//密码必须包含字母
        }else if(passWord.length() < 7){
            return MyselfJSONResult.errorMsg(UserRegisterEnum.PASSWORD_TOO_SHORT.getMsg());//密码不能为空且要大于7个字符
        }
        //第一步：校验用户名是否存在重复
        if(!emptyChecker.isEmpty(userInfoCommonService.getById(userIo.getUserId()))){
            return MyselfJSONResult.errorMsg(UserRegisterEnum.USER_HAS_REGISTERED.getMsg());//用户名已经被注册
        }
        //第二步：检验邮箱格式是否正确
        String email = userIo.getEmail();
        if (!email.contains("@")){
            return MyselfJSONResult.errorMsg(UserRegisterEnum.ERROR_EMAIL.getMsg());//邮箱格式不正确
        }
        //第三步：插入操作
        try{
            userInfoCommonService.insert(userInfoPojo);
        }catch(Exception e){
            e.printStackTrace();
            return MyselfJSONResult.errorMsg(UserRegisterEnum.REGISTER_FAILED.getMsg());//注册失败
        }
        return MyselfJSONResult.ok(userIo.getUserId());//注册成功
    }

    @Override
    public MyselfJSONResult userLogin(LoginIo loginIo) {
        //第一步：验证用户名是否存在
        if(emptyChecker.isEmpty(userInfoCommonService.getById(loginIo.getUserId()))){
            return MyselfJSONResult.errorMsg(UserLoginEnum.ERROR_USER_ID.getMsg());//用户名不存在
        }
        //第二步：验证用户名密码是否匹配
        String passWord = userInfoCommonService.getById(loginIo.getUserId()).getPassWord();
        if(!loginIo.getPassWord().equals(passWord)){
            return MyselfJSONResult.errorMsg(UserLoginEnum.ERROR_PASSWORD.getMsg());//密码或用户名错误
        }
        return MyselfJSONResult.ok(loginIo.getUserId());//登陆成功
    }
}
