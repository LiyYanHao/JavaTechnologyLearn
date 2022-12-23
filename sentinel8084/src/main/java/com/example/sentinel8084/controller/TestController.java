package com.example.sentinel8084.controller;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.example.sentinel8084.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyanhao
 * @Date 2022-12-09 14:09
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return testService.sayHello(name);
    }
}
