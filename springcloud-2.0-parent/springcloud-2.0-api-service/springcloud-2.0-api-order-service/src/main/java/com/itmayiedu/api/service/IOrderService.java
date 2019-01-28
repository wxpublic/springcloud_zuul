package com.itmayiedu.api.service;

import com.itmayiedu.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService{
    /**
     * 订单调用会员服务，注意：此方法调用需要带参数
     */
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    /**
     * 演示集群会员服务端口变换效果
     * @return
     */
    @RequestMapping("/orderToMemberDiffPort")
    public String orderToMemberDiffPort();

    /**
     * 订单服务调用会员服务接口信息
     * @return
     */
    @RequestMapping("/getOrderUserInfo")
    public ResponseBase getOrderUserInfo();

    /**
     * 演示熔断器Hystrix;解决服务的雪崩效应
     */
    @RequestMapping("/orderHystrix")
    public ResponseBase orderHystrix();

    /**
     * 本方法用意；配合熔断方法orderHystrix，测试不同服务请求默认采用线程池隔离;线程名不一样；
     */
    @RequestMapping("/testOrderInfo")
    public ResponseBase testOrderInfo();
}
