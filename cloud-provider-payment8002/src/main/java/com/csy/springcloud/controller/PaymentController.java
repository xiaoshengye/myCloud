package com.csy.springcloud.controller;

import com.csy.springcloud.entities.CommonResult;
import com.csy.springcloud.entities.Payment;
import com.csy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 类名: PaymentController
 *
 * @author CSY
 * @date 2020/8/22
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        } else {
            return new CommonResult(500,"插入数据库失败",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        } else {
            return new CommonResult(500,"查询失败",null);
        }
    }
}
