package com.example.data.service;

import com.example.data.data.Payment;
import com.example.data.data.PaymentEntity;
import com.example.data.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final PaymentRepository paymentRepository;

    @KafkaListener(groupId = "consumer", topics = "completedPayments")
    public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
        logger.info(message);
        acknowledgment.acknowledge();

        create(message);
    }

    public PaymentEntity create(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity(payment.getId(),
                payment.getSenderId(),
                payment.getAmount(),
                payment.getComment());
        return paymentRepository.save(paymentEntity);
    }

    public List<PaymentEntity> getAll() {
        return paymentRepository.findAll();
    }
}
