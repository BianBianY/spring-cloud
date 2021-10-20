package com.tw.orderservice.controller;

import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.apicommons.dto.PaymentRequest;
import com.tw.orderservice.ribbon.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author yang.bian
 * @create 2021/9/3 17:31
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalanced loadBalanced;

    public static final String PAYMENT_SERVICE = "http://payment-service";

    @GetMapping("/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/{id}", CommonResult.class, id);
    }

    @GetMapping
    public CommonResult<List<Payment>> findAllPayments() {
        ServiceInstance instance = loadBalanced.getInstance(discoveryClient.getInstances("payment-service"));
        return restTemplate.getForObject(instance.getUri() + "/payment", CommonResult.class);
    }

    @PostMapping
    public CommonResult<Payment> createPayment(@RequestBody PaymentRequest request) {
        return restTemplate.postForObject(PAYMENT_SERVICE + "/payment", request, CommonResult.class);
    }

    private URI getUri() {
        ServiceInstance serviceInstance = discoveryClient.getInstances(OrderController.PAYMENT_SERVICE).get(0);
        return serviceInstance.getUri();
    }
}
