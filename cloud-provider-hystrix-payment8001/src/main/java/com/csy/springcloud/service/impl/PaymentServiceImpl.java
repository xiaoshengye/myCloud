package com.csy.springcloud.service.impl;

import com.csy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 类名: PaymentServiceImpl
 *
 * @author CSY
 * @date 2020/8/23
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOk(Integer id) {
        return "线程池："+Thread.currentThread().getName()+" paymentOk,id:"+id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentTimeOut,id:"+id+" 成功^_^";
    }

    @Override
//    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    public String paymentError(Integer id) {
        int age = 1/0;
        return "线程池："+Thread.currentThread().getName()+" paymentError,id:"+id+" 成功^_^";
    }


    private String paymentTimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"8001系统繁忙，请稍后再试 paymentTimeOutHandler,id:"+id+" 失败::>_<::";
    }

    //#region 服务熔断

    @Override
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw new RuntimeException("****id不能小于0****");
        }

        return "线程池："+Thread.currentThread().getName()+" paymentCircuitBreaker,id:"+id+" 成功^_^";
    }

    private String circuitBreakerFallback(Integer id){
        return "服务熔断circuitBreakerFallback：id:"+id;
    }

    //#endregion

}
