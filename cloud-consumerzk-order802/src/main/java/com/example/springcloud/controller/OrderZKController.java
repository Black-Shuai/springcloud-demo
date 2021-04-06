package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/api/zkconsumer/payment802")
public class OrderZKController {
    public static final String INCKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/findServerPort")
    public CommonResult paymentInfo(){
        String result=restTemplate.getForObject(INCKE_URL+"/api/payment8004/findServerPort",String.class);
        return new CommonResult(200,"获取数据成功",result);
    }
}
