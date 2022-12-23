package com.example.sentinelopenfeign8087.controller;

import com.example.sentinelopenfeign8087.feign.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @author liyanhao
 * @Date 2022-12-09 17:56
 */
@RestController
public class TestController {
    @Resource
    private TestClient tstClient;


    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String getEcho(@PathVariable String str) {
        String echo = tstClient.echo(str);
        return "sentinel feign" + echo;
    }

    @RequestMapping(value = "/echoB/{str}", method = RequestMethod.GET)
    public String getEchoB(@PathVariable String str) {
        String echo = tstClient.echo(str);
        return "sentinel feign  /echoB/{str} " + echo;
    }






}
