package com.example.sentinelopenfeign8086.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.example.sentinelopenfeign8086.feign.TestClient;
import com.example.sentinelopenfeign8086.service.OrderService;
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

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String getEcho(@PathVariable String str) {
//        String echo = tstClient.echo(str);
        String order = orderService.getOrder();
        return "sentinel feign" + order;
    }

    @RequestMapping(value = "/echoB/{str}", method = RequestMethod.GET)
    public String getEchoB(@PathVariable String str) {
//        String echo = tstClient.echo(str);
        String order = orderService.getOrder();
        return "sentinel feign  /echoB/{str} " + order;
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        return "------testD";
    }

    //blockHandler使用自定义的处理器
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }
    //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
    public String dealHandler_testHotKey(String p1, String p2, BlockException exception)
    {
        return "-----dealHandler_testHotKey";
    }





}
