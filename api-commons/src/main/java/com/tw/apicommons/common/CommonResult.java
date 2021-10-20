package com.tw.apicommons.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yang.bian
 * @create 2021/9/1 18:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    private Integer code;
    private String message;
    private T item;

    public static <K> CommonResult<K> SUCCESS(K item) {
        return new CommonResult<>(200, SUCCESS, item);
    }

    public static <K> CommonResult<K> FAILED(String message) {
        return new CommonResult<>(400, message, null);
    }

}
