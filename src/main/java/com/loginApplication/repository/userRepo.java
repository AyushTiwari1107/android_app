package com.loginApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginApplication.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface userRepo extends JpaRepository<userEntity, Long> {
    Optional<userEntity> findByUsername(String username);

}
