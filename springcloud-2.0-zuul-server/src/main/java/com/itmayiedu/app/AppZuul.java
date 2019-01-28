package com.itmayiedu.app;

import com.itmayiedu.app.Filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-28 下午 1:12
 */
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy   //开启网关代理
public class AppZuul {
    public static void main(String[] args) {
        SpringApplication.run(AppZuul.class);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}

