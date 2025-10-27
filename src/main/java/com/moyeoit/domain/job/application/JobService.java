package com.moyeoit.domain.job.application;

import com.moyeoit.domain.job.application.dto.JobsDto;
import com.moyeoit.domain.job.domain.entity.Job;
import com.moyeoit.domain.job.domain.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public JobsDto getJobs() {
        List<Job> jobs = jobRepository.findAll();
        return JobsDto.of(jobs);
    }

}