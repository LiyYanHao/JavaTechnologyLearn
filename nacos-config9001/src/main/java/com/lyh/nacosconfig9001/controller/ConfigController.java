package com.lyh.nacosconfig9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyanhao
 * @Date 2022-12-08 16:41
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${myAppName}")
    private String myAppName;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
    @RequestMapping("/getApp")
    public String getApp() {
        return myAppName;
    }
}
