package com.myself.sbdemo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:AwakeningCode
 * @Date: Created in 14:07 2018\3\15 0015
 */
@Configuration //代表会引用资源文件
@ConfigurationProperties(prefix = "com.myself.opensource") //设置前缀
@PropertySource(value = "classpath:resource.properties") //配置资源文件地址，版本差异
public class Resource {
    private String name;
    private String website;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
