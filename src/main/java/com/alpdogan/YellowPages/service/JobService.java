package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.SaveJobRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateJobRequestDto;
import com.alpdogan.YellowPages.dto.responseDto.JobResponseDto;
import com.alpdogan.YellowPages.entity.Category;
import com.alpdogan.YellowPages.entity.Firm;
import com.alpdogan.YellowPages.entity.Job;
import com.alpdogan.YellowPages.repository.FirmRepository;
import com.alpdogan.YellowPages.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    FirmRepository firmRepository;

    @Autowired
    ModelMapper modelMapper;


    public String saveJob(SaveJobRequestDto saveJobRequestDto) {

        String titleRequest = saveJobRequestDto.getTitle();
        int firmIdRequest = saveJobRequestDto.getFirmId();
        int categoryIdRequest = saveJobRequestDto.getCategoryId();

        Category category = categoryService.findCategory(categoryIdRequest);
        Firm firm = firmRepository.findById(firmIdRequest).get();

        Job job = new Job();

        job.setTitle(titleRequest);
        job.setFirm(firm);
        job.setCategory(category);

        List<Job> jobList = new ArrayList<>();
        jobList.add(job);
        category.setJob(jobList);

        firm.setJobs(jobList);

        jobRepository.save(job);

        return job.getTitle() + " has been successfully created.";

    }

    public List<JobResponseDto> findAllJobs() {

        Iterable<Job> jobs = jobRepository.findAll();

        List<JobResponseDto> jobResponseDtos = new ArrayList<>();

        for (Job job : jobs) {

            JobResponseDto jobResponseDto = modelMapper.map(job, JobResponseDto.class);
            jobResponseDtos.add(jobResponseDto);

        }

        return jobResponseDtos;

    }

    public Job findJob(Integer jobId) {

        return jobRepository.findById(jobId).get();

    }

    public String updateJob(UpdateJobRequestDto updateJobRequestDto) {

        int idJobRequest = updateJobRequestDto.getId();
        String titleRequest = updateJobRequestDto.getTitle();
        int firmIdRequest = updateJobRequestDto.getFirmId();
        int categoryIdRequest = updateJobRequestDto.getCategoryId();

        Category category = categoryService.findCategory(categoryIdRequest);
        Firm firm = firmRepository.findById(firmIdRequest).get();

        Optional<Job> jobOptional = jobRepository.findById(idJobRequest);
        Job job = jobOptional.get();

        job.setTitle(String.valueOf(idJobRequest));
        job.setTitle(titleRequest);
        job.setFirm(firm);
        job.setCategory(category);

        jobRepository.save(job);

        return "Changes saved successfully.";

    }

    public String deleteJobById(Integer jobId) {

        Optional<Job> optionalJob = jobRepository.findById(jobId);

        Job job = optionalJob.get();
        jobRepository.delete(job);

        return "The book has been deleted.";

    }

}


















