package com.example.aggregator.client;

import com.example.aggregator.data.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "data")
public interface DataClient {
    @GetMapping
    List<Payment> getAllPayments();
}
