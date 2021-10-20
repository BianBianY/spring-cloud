package com.tw.paymentservice.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tw.apicommons.common.CommonResult;
import com.tw.apicommons.domain.Payment;
import com.tw.paymentservice.repository.PaymentRepository;
import com.tw.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
    @HystrixCommand(fallbackMethod = "findPaymentByIdHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public CommonResult<Payment> findPaymentById(Long id) {
        try {
            TimeUnit.MILLISECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional<Payment> optionalPayment = paymentRepository.findOne(id);
        Payment payment = optionalPayment.orElse(Payment.builder().serial("not fund").build());
        return CommonResult.SUCCESS(payment);
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPaymentsHandle", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public CommonResult<List<Payment>> findAllPayments(int ids) {
        if (ids < 0) {
            int a = 1 / 0;
        }

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

    public CommonResult<Payment> findPaymentByIdHandle( Long id) {
        return CommonResult.FAILED("失败了---》降级");
    }

    public CommonResult<List<Payment>> findPaymentsHandle(int a) {
        return CommonResult.FAILED("失败了 降级 1/0:::"+a);
    }
}
