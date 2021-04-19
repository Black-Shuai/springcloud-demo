package com.example.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain803 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain803.class,args);
    }
}
