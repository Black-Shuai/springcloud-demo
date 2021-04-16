package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/api/comsumer/payment")
public class OrderController {

    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/findServerPort")
    public CommonResult findServerPort(){
        return restTemplate.getForObject(PAYMENT_URL+"/api/payment/findServerPort",CommonResult.class);
    }
}
