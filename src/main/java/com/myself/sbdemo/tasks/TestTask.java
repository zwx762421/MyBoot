package com.myself.sbdemo.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:AwakeningCode
 * @Date: Created in 23:34 2018\3\16 0016
 */
@Component
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //定义每过3秒执行任务
    //@Scheduled(fixedRate = 3000)
    @Scheduled(cron = "4-40 * * * * ?") //SpringBoot不支持年，有效为6个
    public void reportCurrentTime(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
