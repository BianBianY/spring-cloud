package com.tw.paymentservice.controller;

import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.apicommons.dto.PaymentRequest;
import com.tw.paymentservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yang.bian
 * @create 2021/9/2 18:06
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        return paymentService.findPaymentById(id);
    }

    @GetMapping("/breaker/{i}")
    public CommonResult<List<Payment>> findAllPayments( @PathVariable int i) {
        return paymentService.findAllPayments(i);
    }

    @PostMapping
    public CommonResult<Payment> createPayment(@RequestBody PaymentRequest request) {
        return paymentService.createPayment(Payment.builder().serial(request.getSerial()).build());
    }

    @GetMapping("/discovery")
    public Object discovery() {
        return discoveryClient;
    }
}
