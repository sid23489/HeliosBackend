package com.siddharth.helios.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JobKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public JobKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJob(String jobId, String command) {
        kafkaTemplate.send("jobs-topic", jobId, command);
        System.out.println("Job " + jobId + " pushed to Kafka.");
    }
}
