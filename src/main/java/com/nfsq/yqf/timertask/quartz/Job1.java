package com.nfsq.yqf.timertask.quartz;

import org.springframework.stereotype.Component;

@Component
public class Job1 {
    public void execute(){
        System.out.println("job1被调用了");
    }
}
