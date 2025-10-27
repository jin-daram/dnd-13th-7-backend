package com.moyeoit.domain.user.infra.jpa;

import com.moyeoit.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
