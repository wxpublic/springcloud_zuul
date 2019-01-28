package com.itmayiedu.api.fallback;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.feign.MemberServiceFeign;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2019-01-24 上午 11:43
 */
@Component
public class MemberServiceFallBack extends BaseApiService implements MemberServiceFeign {

    @Override
    public UserEntity getMember(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("尊敬的客户,你好;因服务故障原因，没有获取到用户信息(以类方式实现熔断降级处理)");
        return userEntity;
    }

    @Override
    public String getMemberGroup() {
        return "尊敬的客户,你好;因服务故障原因，本来设定好的端口魔术暂时取消，敬请期待。。(以类方式实现熔断降级处理)";
    }

    /**
     * 服务降级所执行的方法，fallback对应方法
     */
    public ResponseBase getMemberUserInfo(){
        return setResultError("尊敬的客户,你好;因服务故障原因，系统对您的请求采取了服务降级处理,Please try again later..(以类方式实现熔断降级处理)");
    }
}
