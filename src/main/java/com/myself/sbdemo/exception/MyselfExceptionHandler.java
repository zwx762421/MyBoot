package com.myself.sbdemo.exception;

import com.myself.sbdemo.util.MyselfJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:AwakeningCode
 * @Date: Created in 17:27 2018\3\15 0015
 */
@ControllerAdvice
public class MyselfExceptionHandler {

    public static final String MYSELF_ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)
    /*public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();

        ModelAndView mav = new ModelAndView();

        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        //返回的页面
        mav.setViewName(MYSELF_ERROR_VIEW);
        return mav;
    }*/

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,HttpServletResponse response,Exception e)throws Exception{
        e.printStackTrace();
        if (isAjax(request)){
            return MyselfJSONResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURL());
            //返回的页面
            mav.setViewName(MYSELF_ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断是否是ajax请求
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
            return (httpRequest.getHeader("X-Requested-With")!=null
            && "XMLHttpRequest".equals(httpRequest.getHeader("X-Reuqest-With").toString()));
    }


}
