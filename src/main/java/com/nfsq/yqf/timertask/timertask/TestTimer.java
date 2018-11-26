package com.nfsq.yqf.timertask.timertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Scheduled的注解是spring自带的定时任务注解
 * 可以用来执行一些简单的定时任务
 * 但必须加上@EnableScheduling注解
 * 不需要引入jar包
 * 如果要使用比较复杂的定时任务需要用到Quartz框架
 */
@Component
public class TestTimer {
    @Scheduled(cron = "0 0/2 * * * ?")
    public void sayHello(){
        System.out.println("Hello");
    }
}
