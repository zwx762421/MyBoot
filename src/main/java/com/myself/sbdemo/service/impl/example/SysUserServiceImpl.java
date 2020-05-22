package com.myself.sbdemo.service.impl.example;

import com.github.pagehelper.PageHelper;
import com.myself.sbdemo.mapper.example.SysUserMapper;
import com.myself.sbdemo.mapper.example.SysUserMapperCustom;
import com.myself.sbdemo.pojo.example.SysUser;
import com.myself.sbdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:AwakeningCode
 * @Date: Created in 17:33 2018\3\16 0016
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserMapperCustom sysUserMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SysUser user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, int pageSize) {
        //开始分页
        PageHelper.startPage(page,pageSize);
        //类似的sql实体
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getName())){
            criteria.andLike("name","%"+user.getName()+"%");
        }
        example.orderBy("age").desc();
        List<SysUser> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserByIdCustom(String id) {
        List<SysUser> userList = sysUserMapperCustom.queryUserSimplyInfoById(id);
        if (userList!=null && !userList.isEmpty()){
            return (SysUser)userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(SysUser user) {
        userMapper.insert(user);
        int a = 1 / 0;
        user.setName("mmmmmmm");
        userMapper.updateByPrimaryKeySelective(user);
    }
}
