package com.tw.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceZookeeperApplication {

    public static void main(String[] args) {
       SpringApplication.run(PaymentServiceZookeeperApplication.class, args);
    }
}