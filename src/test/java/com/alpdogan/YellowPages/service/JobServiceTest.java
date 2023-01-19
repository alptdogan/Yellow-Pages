package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.SaveJobRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateJobRequestDto;
import com.alpdogan.YellowPages.entity.Job;
import com.alpdogan.YellowPages.repository.FirmRepository;
import com.alpdogan.YellowPages.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JobServiceTest {

    @Mock
    JobRepository jobRepository;

    @InjectMocks
    JobService jobService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    FirmService firmService;

    @Mock
    CategoryService categoryService;

    @Mock
    FirmRepository firmRepository;

    @Test
    void testSaveJob() {

        SaveJobRequestDto saveJobRequestDtoMock = mock(SaveJobRequestDto.class);
        saveJobRequestDtoMock.setTitle("Software Developer");

        Job jobMock = mock(Job.class);
        jobMock.setId(0);

        when(modelMapper.map(saveJobRequestDtoMock, Job.class)).thenReturn(jobMock);
        when(jobRepository.save(jobMock)).thenReturn(jobMock);

        String saveJob = jobService.saveJob(saveJobRequestDtoMock);
        String saveJobMessage = jobMock.getTitle() + " has been created successfully.";

        assertEquals(saveJob, saveJobMessage);

    }

    @Test
    void testFindJob() {

        Job jobMock = mock(Job.class);
        jobMock.setId(1);

        when(jobRepository.findById(jobMock.getId())).thenReturn(Optional.of(jobMock));

        Job findJob = jobService.findJob(jobMock.getId());

        assertEquals(jobMock, findJob);

    }

    @Test
    void testUpdateJob() {



        Job jobMock = mock(Job.class);

        jobMock.setId(1);
        jobMock.setTitle("testTitle");
        //jobMock.setCategory(???);

        UpdateJobRequestDto updateJobRequestDtoMock = mock(UpdateJobRequestDto.class);
        updateJobRequestDtoMock.setId(1);
        updateJobRequestDtoMock.setTitle("updateTestTitle");
        updateJobRequestDtoMock.setCategoryId(1);
        updateJobRequestDtoMock.setFirmId(1);

        when(jobRepository.findById(any())).thenReturn(Optional.of(jobMock));
        String updateJob = jobService.updateJob(updateJobRequestDtoMock);
        String updateJobMessage = "Changes Saved Successfully.";

        assertEquals(updateJob, updateJobMessage);

    }

    @Test
    void testDeleteJobById() {

        Job jobMock = mock(Job.class);
        jobMock.setId(1);

        when(jobRepository.findById(jobMock.getId())).thenReturn(Optional.of(jobMock));

        String deleteJobById = jobService.deleteJobById(jobMock.getId());
        String deleteJobMessage = "The job has been deleted.";

        assertEquals(deleteJobById, deleteJobMessage);

    }


}
