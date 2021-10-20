package com.tw.paymentservice.exception;

import com.tw.apicommons.common.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yang.bian
 * @create 2021/9/3 12:03
 */
@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(NotFoundException.class)
    public CommonResult<Object> handleNotFoundException(NotFoundException notFoundException) {
        return CommonResult.FAILED(notFoundException.getMessage());
    }
}
