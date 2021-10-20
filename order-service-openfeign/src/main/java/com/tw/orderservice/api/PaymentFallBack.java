package com.tw.orderservice.api;

import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.apicommons.dto.PaymentRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yang.bian
 * @create 2021/9/6 18:03
 */
@Component
public class PaymentFallBack implements FeignPaymentAPI{
    @Override
    public CommonResult<Payment> findPaymentById(Long id) {
        return CommonResult.FAILED("hahahhahaha");
    }

    @Override
    public CommonResult<List<Payment>> findAllPayments() {
        return null;
    }

    @Override
    public CommonResult<Payment> createPayment(PaymentRequest request) {
        return null;
    }

    @Override
    public Object discovery() {
        return null;
    }
}
