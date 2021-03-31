package com.example.springcloud.service.serviceImp;

import com.example.springcloud.dao.PaymentDao;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PaymentServiceImp implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    public int addPayment(Payment payment){
        return paymentDao.addPayment(payment);
    }

    public Payment findPaymentById(String id){
        return paymentDao.findPaymentById(id);
    }
}
