package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-29 下午 2:22
 */
@SpringBootApplication
@EnableEurekaClient
public class AppPay {
    public static void main(String[] args) {
        SpringApplication.run(AppPay.class);
    }
}
