package com.tw.apicommons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yang.bian
 * @create 2021/9/2 18:19
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String serial;
}
