package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.UserEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.UserRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserDAO implements UserDataAccess {
    private final ProviderConverter providerConverter;
    private UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public User save(User user) {
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }

    public User findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return providerConverter.userEntityToUserModel(userEntity);
        }
        return null;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username); // Nouvelle méthode
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
