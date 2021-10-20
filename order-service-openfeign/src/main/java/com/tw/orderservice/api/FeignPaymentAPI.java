package com.tw.orderservice.api;

import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.apicommons.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author yang.bian
 * @create 2021/9/6 14:28
 */
@Component
@FeignClient(value = "payment-service", fallback = PaymentFallBack.class)
public interface FeignPaymentAPI {
    @GetMapping("/payment/{id}")
    CommonResult<Payment> findPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment")
    CommonResult<List<Payment>> findAllPayments();

    @PostMapping("/payment")
    CommonResult<Payment> createPayment(@RequestBody PaymentRequest request);

    @GetMapping("/payment/discovery")
    Object discovery();
}
