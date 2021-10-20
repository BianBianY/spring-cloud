package com.tw.orderservice.controller;

import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.apicommons.dto.PaymentRequest;
import com.tw.orderservice.api.FeignPaymentAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    private FeignPaymentAPI feignPaymentAPI;

    @GetMapping("/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        return feignPaymentAPI.findPaymentById(id);
    }

    @GetMapping
    public CommonResult<List<Payment>> findAllPayments() {
        return feignPaymentAPI.findAllPayments();
    }

    @PostMapping
    public CommonResult<Payment> createPayment(@RequestBody PaymentRequest request) {
        return feignPaymentAPI.createPayment(request);
    }

}
