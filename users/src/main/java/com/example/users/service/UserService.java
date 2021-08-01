package com.example.users.service;

import com.example.users.data.UserEntity;
import com.example.users.repository.UserRepository;
import com.namics.commons.random.RandomData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> create(List<Long> ids) {
        ids = ids.stream()
                .filter(id -> !userRepository.existsById(id))
                .collect(Collectors.toList());

        return userRepository.saveAll(
                ids.stream()
                        .map(id -> new UserEntity(id, RandomData.username()))
                        .collect(Collectors.toList())
        );
    }
}
