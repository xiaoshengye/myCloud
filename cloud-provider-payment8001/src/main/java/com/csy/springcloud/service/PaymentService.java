package com.csy.springcloud.service;

import com.csy.springcloud.entities.Payment;

/**
 * 类名: PaymentService
 *
 * @author CSY
 * @date 2020/8/22
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Integer id);
}
