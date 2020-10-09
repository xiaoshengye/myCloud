package com.csy.springcloud.service.impl;

import com.csy.springcloud.dao.PaymentDao;
import com.csy.springcloud.entities.Payment;
import com.csy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类名: PaymentServiceImpl
 *
 * @author CSY
 * @date 2020/8/22
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
