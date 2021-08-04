package com.example.users;

import com.example.users.data.UserEntity;
import com.example.users.service.UserService;
import com.namics.commons.random.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UsersApplication implements CommandLineRunner {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(RandomData.username()));
        users.add(new UserEntity(RandomData.username()));
        users.add(new UserEntity(RandomData.username()));
        users.add(new UserEntity(RandomData.username()));
        userService.saveAll(users);
    }
}
