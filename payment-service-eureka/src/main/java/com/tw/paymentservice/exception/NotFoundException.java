package com.tw.paymentservice.exception;

/**
 * @author yang.bian
 * @create 2021/9/3 12:00
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
