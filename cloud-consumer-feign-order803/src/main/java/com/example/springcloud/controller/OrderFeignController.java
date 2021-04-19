package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/api/consumer/feign")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") String id){
        return paymentFeignService.findPaymentById(id);
    }

    @GetMapping(value = "/timeoutPayment")
    public String PaymentFeignTimeout(){
        //openfeign-ribbon，客户端一般默认等待一秒钟
        return paymentFeignService.PaymentFeignTimeout();
    }
}
