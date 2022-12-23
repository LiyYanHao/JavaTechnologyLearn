package com.example.sentinelopenfeign8086.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Component;

/**
 * @author liyanhao
 * @Date 2022-12-12 19:26
 */
@Component
public class OrderService {
    @SentinelResource("getOrder")
    public String getOrder(){
        return "order is order";
    }
}
