package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.service.IOrderService;
import com.itmayiedu.api.feign.MemberServiceFeign;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService{
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    /**
     * 注意：此方法调用需要带参数
     */
    @RequestMapping("/orderToMember")
    public String orderToMember(String name){
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity==null?"没有找到用户信息":userEntity.toString();
    }

    /**
     * 演示集群会员服务端口变换效果，需要开启不同端口的多个生产者Member服务，
     * 原理：Feign客户端自带Ribbon负载均衡（轮询）
     */
    @RequestMapping("/orderToMemberDiffPort")
    public String orderToMemberDiffPort() {
        return memberServiceFeign.getMemberGroup();
    }

    /**
     * 演示超过默认一秒后，系统报超时异常，此时在配置文件设置全局模式的ribbon访问超时属性：
     * ribbon.ReadTimeout 和 ribbon.ConnectTimeout
     */
    @RequestMapping("/getOrderUserInfo")
    public ResponseBase getOrderUserInfo(){
        return memberServiceFeign.getMemberUserInfo();
    }

    /**
     * 演示熔断器Hystrix; 以类方式自动实现服务降级、线程隔离、服务熔断；解决服务的雪崩效应
     * Hystrix有两种保护服务的实现方式：注解和类形式;本项目演示类方式！（推荐使用）
     * 以类方式实现服务降级时，远端方法调用将在新的线程池开启新的线程，采用异步线程执行。
     * 即memberServiceFeign远程调用的会员方法和订单父方法使用不同线程池不同的线程;并异步执行，即服务线程隔离
     *
     * 实现方式：
     * 1、定义类(比如：MemberServiceFallBack)继承memberServiceFeign 接口;
     * 2、在类对应方法内做服务降级处理，并返回结果;
     * 3、在memberServiceFeign接口的注解@FeignClient属性fallback值中添加定义类.class引用(MemberServiceFallBack.class);
     *
     * 服务隔离缺点：占用内存资源是比较大的。
     *
     * 下面的生产者方法getMemberUserInfo()，需要延迟1.5秒返回结果，如果配置文件中Hystrix的超时时间小于1.5秒就会发生服务降级
     * 不设置超时参数，Hystrix的默认超时时间是1秒
     */
    @RequestMapping("/orderHystrix")
    public ResponseBase orderHystrix(){
        System.out.println("orderHystrix方法线程名称:"+Thread.currentThread().getName());
        ResponseBase ret = memberServiceFeign.getMemberUserInfo();
        System.out.println("orderHystrix方法返回:"+ret.getMsg());
        return ret;
    }

    /**
     * 本方法用意；配合熔断方法orderHystrix，测试不同服务请求默认采用线程池隔离;线程名不一样；
     */
    @RequestMapping("/testOrderInfo")
    public ResponseBase testOrderInfo(){
        System.out.println("testOrderInfo方法线程名称:"+Thread.currentThread().getName());
        return setResultSuccess();
    }
}
