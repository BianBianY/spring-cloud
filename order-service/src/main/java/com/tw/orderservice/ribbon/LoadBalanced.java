package com.tw.orderservice.ribbon;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yang.bian
 * @create 2021/9/6 13:00
 */
public interface LoadBalanced {
    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
