package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.service.IPayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-29 下午 2:11
 */
@RestController
public class PayServiceImpl implements IPayService{
    @RequestMapping("/getPay")
    public String getPay() {
        return "Hello Everyone!I'M PayService!  else:我是支付服务,我同订单服务和会员服务在本Demo中没有依赖、调用或业务关系";
    }
}
