package com.tw.paymentservice.service.impl;


import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.paymentservice.exception.NotFoundException;
import com.tw.paymentservice.repository.PaymentRepository;
import com.tw.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author yang.bian
 * @create 2021/9/2 18:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentRepository paymentRepository;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public CommonResult<Payment> findPaymentById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findOne(id);
        Payment payment = optionalPayment.orElseThrow(() -> new NotFoundException("not found"));
        return CommonResult.SUCCESS(payment);
    }

    @Override
    public CommonResult<List<Payment>> findAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        CommonResult<List<Payment>> success = CommonResult.SUCCESS(payments);
        success.setMessage(serverPort + "提供服务");
        return success;
    }

    @Override
    public CommonResult<Payment> createPayment(Payment payment) {
        if (paymentRepository.save(payment) > 0) {
            return CommonResult.SUCCESS(payment);
        }
        throw new RuntimeException();
    }
}
