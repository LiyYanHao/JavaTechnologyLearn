package com.example.sentinelopenfeign8087.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liyanhao
 * @Date 2022-12-08 22:14
 */
@FeignClient(name = "nacos-provider8081")
public interface TestClient {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string);
}
