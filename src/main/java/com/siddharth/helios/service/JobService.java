package com.siddharth.helios.service;

import com.siddharth.helios.dto.JobRequestDTO;
import com.siddharth.helios.entity.Job;
import com.siddharth.helios.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JobSchedulerService jobSchedulerService;

    public Integer addJob(JobRequestDTO jobRequestDTO) {
        Job job = modelMapper.map(jobRequestDTO, Job.class);
        job = jobRepository.save(job);
        try {
            jobSchedulerService.scheduleJob(job);
        }
        catch (Exception e) {
            System.out.println("Failed Scheduling");
            System.out.println(e.getMessage());
        }
        return job.getJobId();
    }

    public List<Integer> getJobs() {
        List<Integer> jobs = jobRepository.findAll().stream()
                .map(Job::getJobId)
                .toList();
        return jobs;
    }
}
