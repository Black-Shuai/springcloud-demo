package com.example.springcloud.controller;

import com.example.springcloud.LB.LoadBalancer;
import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/api/comsumer/payment")
public class OrderController {

//    单机版可以这么写，不能写死
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult addPayment(@RequestBody Payment payment){
        System.out.println("插入数据"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/api/payment/addPayment",payment,CommonResult.class);
    }
    @GetMapping("/findPaymentById/{id}")
    public CommonResult findPaymentById(@PathVariable("id") String id){
        return restTemplate.getForObject(PAYMENT_URL+"/api/payment/findPaymentById/"+id,CommonResult.class);
    }
    @GetMapping("/discovery")
    public CommonResult findPaymentById(){
        return restTemplate.getForObject(PAYMENT_URL+"/api/payment/discovery",CommonResult.class);
    }
    @GetMapping("/getForEntity/{id}")
    public CommonResult getPaymentById(){
        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/api/payment/discovery",CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(400,"操作失败");
        }
    }

    @GetMapping(value = "/getPaymentLB")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if (instances==null||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance= loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/api/payment/getPaymentLB",String.class);
    }
}
