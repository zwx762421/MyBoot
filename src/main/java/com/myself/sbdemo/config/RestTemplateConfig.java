package com.myself.sbdemo.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.xml.soap.Name;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：resttemplate默认配置
 *
 * @Author ZhangWeixin
 */
@Configuration
@Slf4j
public class RestTemplateConfig {

    @Bean
    @Qualifier("restTemplateConfig")
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        RestTemplate restTemplate = new RestTemplate(factory);
        /**
         * FastJson替换Jackson
         * Jackson的JsonProperty注解对接响应JsonResult生效
         * FastJson的JSONField注解对接口响应JsonResult无效
         */
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //添加TEXT_HTML类型
        MediaType[] mediaTypes = new MediaType[]{
                MediaType.TEXT_HTML,
                MediaType.APPLICATION_JSON,
                MediaType.TEXT_PLAIN,
                MediaType.APPLICATION_FORM_URLENCODED
        };
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(mediaTypes));
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        //删除原有Jackson和StringHttp转换器
        List<HttpMessageConverter<?>> removeConverterList = Lists.newArrayList();
        for(HttpMessageConverter<?> item:converterList){
            if(MappingJackson2HttpMessageConverter.class == item.getClass() || StringHttpMessageConverter.class == item.getClass()){
                removeConverterList.add(item);
            }
        }
        converterList.removeAll(removeConverterList);
        converterList.add(fastJsonHttpMessageConverter);
        converterList.add(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        restTemplate.setMessageConverters(converterList);
        log.info("HttpMessageConverter构造成功，重构后数量,{}",converterList.size());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(50000);//单位 ms
        factory.setConnectTimeout(50000);//单位 ms
        return factory;
    }
}
