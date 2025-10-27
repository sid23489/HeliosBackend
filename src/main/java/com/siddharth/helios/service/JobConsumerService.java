package com.siddharth.helios.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JobConsumerService {

    @KafkaListener(topics = "jobs-topic", groupId = "worker-group")
    public void consumeJob(String jobId) {
        System.out.println("Executing Job ID: " + jobId);

        // Perform the actual business logic here:
        // e.g., call a REST API, run a batch process, update DB, etc.
    }
}
