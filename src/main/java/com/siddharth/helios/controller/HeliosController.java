package com.siddharth.helios.controller;

import com.siddharth.helios.dto.JobRequestDTO;
import com.siddharth.helios.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("helios")
public class HeliosController {

    @Autowired
    private JobService jobService;
    @PostMapping("/job")
    public ResponseEntity<String> addJob(@RequestBody JobRequestDTO jobRequestDTO) {
        System.out.println(jobRequestDTO);
        return ResponseEntity.ok("Job Added Successfully");
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<String>> getJobs() {
        System.out.println("fetch all jobs");
        return ResponseEntity.ok(new ArrayList<>(List.of("2","3","4")));
    }
}
