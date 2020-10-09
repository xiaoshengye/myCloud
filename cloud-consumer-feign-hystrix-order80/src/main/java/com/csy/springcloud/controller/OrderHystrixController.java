package com.csy.springcloud.controller;

import com.csy.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名: OrderHystrixController
 *
 * @author CSY
 * @date 2020/8/23
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
//@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentOk(id);
        return result;
    }


//    @HystrixCommand(fallbackMethod = "consumerTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @GetMapping("/hystrix/timeout/{id}")
    //@HystrixCommand
    public String paymentTimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentTimeOut(id);
        return result;
    }


//    @HystrixCommand(fallbackMethod = "consumerTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @GetMapping("/hystrix/error/{id}")
    //@HystrixCommand
    public String paymentError(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentError(id);
        return result;
    }

    private String consumerTimeOutHandler(Integer id){
        return "consumerTimeOutHandler80：系统繁忙，请稍后再试！";
    }

    private String payment_global_fallback(){
        return "global异常处理信息，系统繁忙，请稍后再试！";
    }
}
