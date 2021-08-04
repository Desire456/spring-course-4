package com.example.aggregator.client;

import com.example.aggregator.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("users")
public interface UserClient {
    @GetMapping
    List<UserDto> getUsers(List<Long> ids);
}
