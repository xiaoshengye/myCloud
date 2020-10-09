package com.csy.springcloud.controller;

import com.csy.springcloud.entities.CommonResult;
import com.csy.springcloud.entities.Payment;
import com.csy.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Applications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private DiscoveryClient discoveryClient;

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

    /**
     * 功能描述: discovery 获取注册服务的信息
     * @param
     * @author CSY
     * @date 2020/8/23 16:29
     * @return java.lang.Object
     */
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info("******element:" +service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instanceInfo : instances){
            log.info(instanceInfo.getServiceId()+"\t"+instanceInfo.getHost()+"\t"+instanceInfo.getPort()+"\t"+instanceInfo.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
