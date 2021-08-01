package com.example.users.controller;

import com.example.users.data.UserEntity;
import com.example.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping
    public List<UserEntity> create(@RequestBody List<Long> ids) {
        return userService.create(ids);
    }
}
