package com.example.springcloud.service;

import com.example.springcloud.entities.CommonResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
//    CommonResult<Payment> getPaymentById(@Param("id") String id);

    @GetMapping(value = "/api/payment/findPaymentById/{id}")
    public CommonResult findPaymentById(@PathVariable("id") String id);

    @GetMapping(value = "/api/payment/timeoutPayment")
    public String PaymentFeignTimeout();
}
