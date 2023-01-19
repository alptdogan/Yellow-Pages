package com.alpdogan.YellowPages.Controller;

import com.alpdogan.YellowPages.dto.requestDto.SaveJobRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateJobRequestDto;
import com.alpdogan.YellowPages.dto.responseDto.JobResponseDto;
import com.alpdogan.YellowPages.entity.Job;
import com.alpdogan.YellowPages.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/saveJob")
    public ResponseEntity<String> saveJob(@RequestBody SaveJobRequestDto saveJobRequestDto) {

        String jobSaveDescription = jobService.saveJob(saveJobRequestDto);

        return new ResponseEntity<>(jobSaveDescription, HttpStatus.OK);

    }

    @GetMapping("/findAllJobs")
    public ResponseEntity<List<JobResponseDto>> findAllJobs() {

        List<JobResponseDto> jobResponseDtos = jobService.findAllJobs();

        return new ResponseEntity<>(jobResponseDtos, HttpStatus.OK);

    }

    @GetMapping("/findJobById")
    public ResponseEntity<Job> findJobById(@RequestParam Integer jobId) {

        Job job = jobService.findJob(jobId);

        return new ResponseEntity<>(job, HttpStatus.OK);

    }

    @PostMapping("/updateJob")
    public ResponseEntity<String> updateJob(@RequestBody UpdateJobRequestDto updateJobRequestDto) {

        String updateJobDescription = jobService.updateJob(updateJobRequestDto);

        return new ResponseEntity<>(updateJobDescription, HttpStatus.OK);

    }

    @DeleteMapping("/deleteJob")
    public ResponseEntity<String> deleteJobById(@RequestParam Integer jobId) {

        String deleteJobDescription = jobService.deleteJobById(jobId);

        return new ResponseEntity<>(deleteJobDescription, HttpStatus.OK);

    }

}
