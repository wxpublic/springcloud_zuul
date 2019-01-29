package com.itmayiedu.app;

import com.itmayiedu.app.Filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
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

    @Bean //实例化Zuul过滤器
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    /**
     * Zuul 能够使用Config配置中心实现实时更新
     * @return
     */
    @RefreshScope
    @ConfigurationProperties
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}

