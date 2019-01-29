# springcloud_zuul
springcloud 网关组件Zuul 过滤拦截和请求转发功能示例

# 业务关系：

（1）zuul网关项目转发请求到支付项目、会员项目、订单项目；

（2）订单项目调用会员项目

（3）支付项目独立存在（验证分布式配置中心刷新功能）

# 功能介绍：

1、本项目主要演示功能：Zuul网关组件请求拦截、转发，Zuul网关自带ribbon负载均衡功能

2、分布式配置中心Config使用；其中这里讲一下手动进行配置刷新的过程：
  
  （1）在码云仓库添加配置文件（https://gitee.com/wx_public/cloud_itmayi_config/tree/master/zuulconfig）；
  
  （2）通过浏览器访问configServer项目/配置文件验证配置是否可以输出到IE，如果可以证明ConfigServer服务搭建OK；
  
  （3）用Postman工具以Post方式访问地址:Zuul网关（作为config客户端）地址/actuator/refresh,提交之后出现新添加节点的一些说明，证明刷新成功，此时可以通过网关对新添加的支付项目配置进行访问

3、Feign客户单演示，组件自带ribbon负载均衡功能（订单项目）

4、Hystrix熔断器进行服务降级、服务隔离（线程级别隔离）、服务熔断（订单项目）；以类方式的熔断实现方式演示（实现方式分注解模式和类模式两种）；
