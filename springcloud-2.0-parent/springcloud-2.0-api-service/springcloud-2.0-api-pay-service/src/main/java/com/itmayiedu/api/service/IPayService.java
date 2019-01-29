package com.itmayiedu.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-29 下午 1:53
 */
public interface IPayService {
    @RequestMapping("/getPay")
    public String getPay();
}
