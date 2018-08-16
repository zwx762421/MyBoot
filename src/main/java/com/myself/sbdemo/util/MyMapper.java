package com.myself.sbdemo.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author:AwakeningCode
 * @Date: Created in 11:55 2018\3\16 0016
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>{
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
