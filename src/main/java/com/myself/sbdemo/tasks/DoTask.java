package com.myself.sbdemo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Author:AwakeningCode
 * @Date: Created in 9:08 2018\3\17 0017
 */
@RestController
@RequestMapping("tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/test1")
    public String test1() throws Exception{
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.doTask1();
        Future<Boolean> b = asyncTask.doTask2();
        Future<Boolean> c = asyncTask.doTask3();
        while (!a.isDone() || !b.isDone() || !c.isDone()){
            if (a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times = "任务全部完成，总耗时： " + (end - start) + "毫秒";
        System.out.println(times);
        return times;
    }

}
