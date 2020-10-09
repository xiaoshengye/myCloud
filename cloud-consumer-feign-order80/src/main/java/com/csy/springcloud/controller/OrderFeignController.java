package com.csy.springcloud.controller;

import com.csy.springcloud.entities.CommonResult;
import com.csy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名: OrderFeignController
 *
 * @author CSY
 * @date 2020/8/23
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut(){
        //openfeign客户端默认等待1秒钟

        return paymentFeignService.paymentFeignTimeOut();
    }
}
