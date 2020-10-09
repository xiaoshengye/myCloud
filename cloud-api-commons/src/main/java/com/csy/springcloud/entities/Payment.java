package com.csy.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * 类名: Payment
 *
 * @author CSY
 * @date 2020/8/22
 */
@Data
public class Payment implements Serializable {
    private Integer id;
    private String serial;

}
