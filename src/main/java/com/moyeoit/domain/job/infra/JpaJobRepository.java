package com.moyeoit.domain.job.infra;

import com.moyeoit.domain.job.domain.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaJobRepository extends JpaRepository<Job, Long> {
}
