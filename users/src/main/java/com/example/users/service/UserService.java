package com.example.users.service;

import com.example.users.data.UserEntity;
import com.example.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAll(List<Long> ids) {
        return userRepository.findAllByIdIn(ids);
    }

    public List<UserEntity> saveAll(List<UserEntity> users) {
        return userRepository.saveAll(users);
    }
}
