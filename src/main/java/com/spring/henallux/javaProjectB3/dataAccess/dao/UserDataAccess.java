package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.model.User;


public interface UserDataAccess {
    User save(User user);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
