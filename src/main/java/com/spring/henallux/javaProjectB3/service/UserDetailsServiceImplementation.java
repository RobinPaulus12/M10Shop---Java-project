package com.spring.henallux.javaProjectB3.service;

import com.spring.henallux.javaProjectB3.dataAccess.dao.UserDAO;
import com.spring.henallux.javaProjectB3.dataAccess.dao.UserDataAccess;
import com.spring.henallux.javaProjectB3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserDataAccess userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
