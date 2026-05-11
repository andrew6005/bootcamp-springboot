package com.ex3.ex3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ex3.ex3.entity.UserEntity;
import com.ex3.ex3.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    public UserEntity updateUser(Long id,
                                 UserEntity user) {

        user.setId(id);

        return userRepository.save(user);
    }
}