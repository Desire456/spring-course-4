package com.example.aggregator.client;

import com.example.aggregator.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("users")
public interface UserClient {
    @PostMapping
    List<UserDto> createUsers(List<Long> ids);
}
