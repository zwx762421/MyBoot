package com.myself.sbdemo.config;

import com.myself.sbdemo.controller.interceptor.OneInterceptor;
import com.myself.sbdemo.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:AwakeningCode
 * @Date: Created in 9:23 2018\3\17 0017
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                .addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

        super.addInterceptors(registry);
    }
}
