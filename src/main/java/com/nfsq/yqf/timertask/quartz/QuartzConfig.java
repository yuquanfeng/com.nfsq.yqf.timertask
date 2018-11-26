package com.nfsq.yqf.timertask.quartz;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
    /**
     *
     */
//    @Bean("jobDetail")
//    public MethodInvokingJobDetailFactoryBean getMJDF(MyJob myJob){
//        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
//        methodInvokingJobDetailFactoryBean.setTargetObject(myJob);
//        methodInvokingJobDetailFactoryBean.setTargetMethod("execute");
//        return methodInvokingJobDetailFactoryBean;
//    }
//    @Bean("myJobTigger")
//    public CronTriggerFactoryBean getCronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail){
//        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
//        cronTriggerFactoryBean.setJobDetail(jobDetail.getObject());
//        cronTriggerFactoryBean.setCronExpression("0/5 * * * * ? ");
//        return cronTriggerFactoryBean;
//    }
//    @Bean("schedler")
//    public SchedulerFactoryBean getSchedulerFactoryBean(Trigger myJobTigger){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setTriggers(myJobTigger);
//        return schedulerFactoryBean;
//
//    }
    @Bean("jobDetail1")
    public MethodInvokingJobDetailFactoryBean getJobDetail1(Job1 job1){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(job1);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }
    @Bean("jobDetail2")
    public MethodInvokingJobDetailFactoryBean getJobDetail2(Job2 job2){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        jobDetail.setTargetObject(job2);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }

    @Bean("tigger1")
    public CronTriggerFactoryBean getTriggeer1(@Qualifier("jobDetail1") MethodInvokingJobDetailFactoryBean jobDetail1){
        CronTriggerFactoryBean trigger1 = new CronTriggerFactoryBean();
        trigger1.setJobDetail(jobDetail1.getObject());
        trigger1.setCronExpression("0/5 * * * * ? ");
        return trigger1;
    }
    @Bean("tigger2")
    public CronTriggerFactoryBean getTrigger(@Qualifier("jobDetail2") MethodInvokingJobDetailFactoryBean jobDetail2){
        CronTriggerFactoryBean trigger2 = new CronTriggerFactoryBean();
        trigger2.setJobDetail(jobDetail2.getObject());
        trigger2.setCronExpression("0/5 * * * * ? ");
        return trigger2;
    }
    @Bean
    public SchedulerFactoryBean getSchedul(Trigger[] triggers){
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(triggers);
        return scheduler;
    }
}
