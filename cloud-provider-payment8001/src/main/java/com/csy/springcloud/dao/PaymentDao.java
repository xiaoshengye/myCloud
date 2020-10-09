package com.csy.springcloud.dao;

import com.csy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类名: PaymentDao
 *
 * @author CSY
 * @date 2020/8/22
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(Integer id);
}
