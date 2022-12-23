package com.example.openfeignconsumer8083.controller;

import com.example.openfeignconsumer8083.feign.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liyanhao
 * @Date 2022-12-08 22:08
 */
@RestController
public class OpenFeignController {

    @Resource
    private TestClient testClient;

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello OpenFeign " + testClient.echo(string);
    }


}
