package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URL;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/api/comsumer/payment")
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult addPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/api/payment/addPayment",payment,CommonResult.class);
    }
    @GetMapping("/findPaymentById/{id}")
    public CommonResult findPaymentById(@PathVariable("id") String id){
        return restTemplate.getForObject(PAYMENT_URL+"/api/payment/findPaymentById/"+id,CommonResult.class);
    }
}
