package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/api/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/addPayment")
    public CommonResult addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        log.info("********插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入数据成功,服务端口号:"+serverPort,result);
        }else {
            return new CommonResult(400,"插入数据失败:服务端口号:"+serverPort);
        }
    }
    @GetMapping(value = "/findPaymentById/{id}")
    public CommonResult findPaymentById(@PathVariable("id") String id){
        Payment result = paymentService.findPaymentById(id);
        log.info("********获取结果"+result);
        if(result!=null){
            return new CommonResult(200,"获取数据成功,服务端口号:"+serverPort,result);
        }else {
            return new CommonResult(400,"获取数据失败,服务端口号:"+serverPort);
        }
    }

    @GetMapping(value = "/discovery")
    public CommonResult disvcovery(){
        List<String> services=discoveryClient.getServices();
        for (String element:services){
            log.info("*****element"+element);
        }
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return new CommonResult(200,"获取数据成功,服务端口号:"+serverPort,this.discoveryClient);
    }
}
