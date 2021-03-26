package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public int addPayment(Payment payment);

    /**
     * @param id
     * @return
     */
    public Payment findPaymentById(String id);
}
