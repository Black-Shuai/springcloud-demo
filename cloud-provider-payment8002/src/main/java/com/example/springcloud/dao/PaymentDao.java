package com.example.springcloud.dao;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int addPayment(@Param("payment") Payment payment);

    public Payment findPaymentById(@Param("id") String id);
}
