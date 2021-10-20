package com.tw.paymentservice.service;


import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;

import java.util.List;

/**
 * @author yang.bian
 * @create 2021/9/2 18:05
 */
public interface PaymentService {
    CommonResult<Payment> findPaymentById(Long id);

    CommonResult<List<Payment>> findAllPayments(int ids);

    CommonResult<Payment> createPayment(Payment payment);
}
