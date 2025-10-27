package com.siddharth.helios.service;

import com.siddharth.helios.entity.Job;
import com.siddharth.helios.quartz.ExecuteJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSchedulerService {
    @Autowired
    private Scheduler scheduler;

    public void scheduleJob(Job job) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ExecuteJob.class)
                .withIdentity(job.getJobId().toString())
                .usingJobData("command", job.getCommand())
                .usingJobData("jobId", job.getJobId().toString())
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpr()))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }
}
