package com.tw.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang.bian
 * @create 2021/9/7 17:35
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${bob}")
    private String name;

    @GetMapping
    public String hello() {
        return name;
    }
}
