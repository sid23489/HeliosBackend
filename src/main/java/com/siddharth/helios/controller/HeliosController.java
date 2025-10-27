package com.siddharth.helios.controller;

import com.siddharth.helios.dto.JobRequestDTO;
import com.siddharth.helios.service.JobService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Integer> addJob(@RequestBody @Valid JobRequestDTO jobRequestDTO) {
        return ResponseEntity.ok(jobService.addJob(jobRequestDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<Integer>> getJobs() {
        return ResponseEntity.ok(jobService.getJobs());
    }
}
