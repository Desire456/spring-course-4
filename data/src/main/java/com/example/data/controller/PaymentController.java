package com.example.data.controller;

import com.example.data.data.PaymentEntity;
import com.example.data.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentEntity> getAll() {
        return paymentService.getAll();
    }
}
