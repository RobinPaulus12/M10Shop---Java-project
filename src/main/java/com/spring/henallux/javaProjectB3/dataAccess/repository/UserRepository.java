package com.spring.henallux.javaProjectB3.dataAccess.repository;

import com.spring.henallux.javaProjectB3.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
