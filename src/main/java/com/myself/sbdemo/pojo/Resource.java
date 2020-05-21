package com.myself.sbdemo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:AwakeningCode
 * @Date: Created in 14:07 2018\3\15 0015
 */
@Configuration //代表会引用资源文件
@ConfigurationProperties(prefix = "com.myself.opensource") //设置前缀
@PropertySource(value = "classpath:resource.properties") //配置资源文件地址，版本差异
@Data
public class Resource {
    private String name;
    private String website;
    private String language;
}
