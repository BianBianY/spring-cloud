package com.tw.orderservice.ribbon.impl;

import com.tw.orderservice.ribbon.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yang.bian
 * @create 2021/9/6 13:02
 */
@Component
public class RandomLoadBalanced implements LoadBalanced {

    private final AtomicInteger visits = new AtomicInteger();

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        return serviceInstances.get(visits.incrementAndGet() % serviceInstances.size());
    }
}
