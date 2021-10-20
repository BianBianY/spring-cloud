package com.tw.paymentservice.repository;


import com.tw.apicommons.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author yang.bian
 * @create 2021/9/1 18:13
 */
@Mapper
public interface PaymentRepository {
    Optional<Payment> findOne(@Param("id") Long id);

    List<Payment> findAll();

    Long save(Payment payment);
}
