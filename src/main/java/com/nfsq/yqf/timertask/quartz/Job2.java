package com.nfsq.yqf.timertask.quartz;

import org.springframework.stereotype.Component;

@Component
public class Job2 {
    public void execute(){
        System.out.println("job2被执行了");
    }
}
