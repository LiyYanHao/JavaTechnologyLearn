package com.example.sentinel8084.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author liyanhao
 * @Date 2022-12-09 14:07
 */
@Service
public class TestService {
    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        System.out.println("在调用了-----");
        return "Hello," + name;
    }
}
