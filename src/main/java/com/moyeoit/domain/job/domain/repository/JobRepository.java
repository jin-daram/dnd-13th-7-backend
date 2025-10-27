package com.moyeoit.domain.job.domain.repository;

import com.moyeoit.domain.job.domain.entity.Job;

import java.util.List;

public interface JobRepository {

    List<Job> findAll();

    boolean existsById(Long id);

}
