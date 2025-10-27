package com.siddharth.helios.quartz;

import com.siddharth.helios.service.JobKafkaProducer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExecuteJob implements Job {
    @Autowired
    private JobKafkaProducer producer;

    @Override
    public void execute(JobExecutionContext context) {
        String jobId = context.getJobDetail().getJobDataMap().getString("jobId");
        String command = context.getJobDetail().getJobDataMap().getString("command");
        producer.sendJob(jobId, command);
    }
}

