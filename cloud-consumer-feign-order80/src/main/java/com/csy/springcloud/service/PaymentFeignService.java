package com.csy.springcloud.service;

import com.csy.springcloud.entities.CommonResult;
import com.csy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 类名: PaymentFeignService
 *
 * @author CSY
 * @date 2020/8/23
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Integer id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeOut();
}
