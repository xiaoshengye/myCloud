package com.csy.springcloud.service;

import com.csy.springcloud.service.impl.PaymentFallbackHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 类名: PaymentHystrixService
 *
 * @author CSY
 * @date 2020/8/23
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackHystrixService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/error/{id}")
    String paymentError(@PathVariable("id") Integer id);
}
