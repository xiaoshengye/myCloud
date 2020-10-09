package com.csy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 类名: CloudConfigCenter3344
 *
 * @author CSY
 * @date 2020/10/4
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344.class,args);
    }
}
