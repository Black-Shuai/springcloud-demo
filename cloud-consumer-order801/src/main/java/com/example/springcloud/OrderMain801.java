package com.example.springcloud;

import com.example.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//根据自己编写的config进行配置，使其能够通过自定义设置进行随机访问服务
//@RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)

public class OrderMain801 {
    public static void main(String[] args){
        SpringApplication.run(OrderMain801.class,args);
    }
}
