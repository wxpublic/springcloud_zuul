package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-23 下午 3:58
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //开启configServer服务器端功能
public class AppConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer.class);
    }
}
