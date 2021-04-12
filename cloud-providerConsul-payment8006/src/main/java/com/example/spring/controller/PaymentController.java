package com.example.spring.controller;

import com.example.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/api/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/findServerPort")
    public CommonResult addPayment(){
        log.info("********插入结果"+serverPort);
        return new CommonResult(200,"获取数据成功,服务端口号:"+serverPort+"/t"+ UUID.randomUUID().toString());
    }
}
