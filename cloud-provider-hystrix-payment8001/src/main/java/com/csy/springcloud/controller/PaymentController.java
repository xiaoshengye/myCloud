package com.csy.springcloud.controller;

import com.csy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名: PaymentController
 *
 * @author CSY
 * @date 2020/8/23
 */
@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentOk(id);
        log.info("********result:"+result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentTimeOut(id);
        log.info("********result:"+result);
        return result;
    }

    @GetMapping("/error/{id}")
    public String paymentError(@PathVariable("id") Integer id){
        String result = paymentService.paymentError(id);
        log.info("********result:"+result);
        return result;
    }

    //#region 服务熔断

    @GetMapping("/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("********result:"+result);
        return result;
    }
    //#endregion
}
