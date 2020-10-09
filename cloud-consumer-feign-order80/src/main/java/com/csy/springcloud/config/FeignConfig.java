package com.csy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名: FeignConfig
 *
 * @author CSY
 * @date 2020/8/23
 */
@Configuration
public class FeignConfig {

    /**
     * 功能描述: 设置feign日志级别
     * NONE: 默认，不显示日志
     * BASIC: 仅记录请求方法、url、响应状态码及请求时间
     * HEADERS: 除了BASIC的内容外，还记录请求和响应的头信息
     * FULL: HEADERS，还记录请求和响应的正文及元数据
     * @author CSY
     * @date 2020/8/23 16:47
     * @return feign.Logger.Level
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
