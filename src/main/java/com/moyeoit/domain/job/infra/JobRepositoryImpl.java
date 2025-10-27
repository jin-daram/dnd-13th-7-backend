package com.moyeoit.domain.job.infra;

import com.moyeoit.domain.job.domain.entity.Job;
import com.moyeoit.domain.job.domain.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobRepositoryImpl implements JobRepository {

    private final JpaJobRepository jpaJobRepository;

    @Override
    public List<Job> findAll() {
        return jpaJobRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return jpaJobRepository.existsById(id);
    }
}
