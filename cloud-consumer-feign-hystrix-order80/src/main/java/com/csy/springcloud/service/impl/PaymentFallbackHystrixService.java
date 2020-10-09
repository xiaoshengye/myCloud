package com.csy.springcloud.service.impl;

import com.csy.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 类名: PaymentFallbackHystrixService
 *
 * @author CSY
 * @date 2020/9/13
 */
@Component
public class PaymentFallbackHystrixService implements PaymentHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return "---PaymentFallbackHystrixService: 【paymentOk】 ";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "---PaymentFallbackHystrixService: 【paymentTimeOut】 ";
    }

    @Override
    public String paymentError(Integer id) {
        return "---PaymentFallbackHystrixService: 【paymentError】 ";
    }
}
