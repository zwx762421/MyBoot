package com.myself.sbdemo.exception;

import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:AwakeningCode
 * @Date: Created in 17:36 2018\3\15 0015
 */
//@RestControllerAdvice
public class MyselfAjaxExceptionHandler {

    //@ExceptionHandler(value = Exception.class)
    public MyselfJSONResult defaultErrorHandler(HttpServletRequest request,
                                                Exception e)throws Exception{
        e.printStackTrace();
        return MyselfJSONResult.errorException(e.getMessage());
    }

}
