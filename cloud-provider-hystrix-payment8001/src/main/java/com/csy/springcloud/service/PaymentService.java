package com.csy.springcloud.service;

/**
 * 类名: PaymentService
 *
 * @author CSY
 * @date 2020/8/23
 */
public interface PaymentService {

    /**
     * 功能描述: 测试成功方法
     * @param id
     * @author CSY
     * @date 2020/8/23 17:21
     * @return java.lang.String
     */
    String paymentOk(Integer id);

    /**
     * 功能描述: 测试超时方法
     * @param id
     * @author CSY
     * @date 2020/8/23 17:22
     * @return java.lang.String
     */
    String paymentTimeOut(Integer id);

    /**
     * 功能描述: 测试报错方法
     * @param id
     * @author CSY
     * @date 2020/9/13 14:06
     * @return java.lang.String
     */
    String paymentError(Integer id);

    /**
     * 功能描述: 服务熔断
     * @param id
     * @author CSY
     * @date 2020/9/13 19:28
     * @return java.lang.String
     */
    String paymentCircuitBreaker(Integer id);
}
