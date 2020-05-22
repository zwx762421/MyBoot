package com.myself.sbdemo.util;

import org.springframework.stereotype.Service;

/**
 * 公用工具类，主要针对mybatis通过查询条件 查询返回类型为实体，且未查到东西的实体，返回会报空指针异常
 * 因此在此处针对这种情况做了处理，仅仅适用于这一种类型的返回公用类，其余类型未过多测试，可能会出问题
 * @return null->true  not null->false
 * @Param Object
 * @Author ZhangWeixin
 */
@Service
public class EmptyChecker {

    public Boolean isEmpty(Object o){
        try{
            if(o.equals(null) || o.equals("")){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            return true;
        }
    }
}
