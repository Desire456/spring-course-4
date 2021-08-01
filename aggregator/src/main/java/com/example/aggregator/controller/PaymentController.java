package com.example.aggregator.controller;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.data.Payment;
import com.example.aggregator.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {
    private final DataClient dataClient;
    private final UserClient userClient;

    @GetMapping
    public List<Payment> getPayments() {
        List<Payment> paymentList = dataClient.getAllPayments();
        List<UserDto> userDtoList = userClient.createUsers(
                paymentList.stream()
                        .map(Payment::getSenderId)
                        .collect(Collectors.toList())
        );
        paymentList.forEach(payment ->
                payment.setUsername(
                        userDtoList.stream()
                                .filter(user -> user.getName().equals(payment.getUsername()))
                                .findFirst()
                                .map(UserDto::getName)
                                .orElse("")
                )
        );

        return paymentList;
    }
}
