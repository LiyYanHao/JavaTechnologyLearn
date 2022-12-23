package com.example.sentinelopenfeign8087;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.sentinelopenfeign8087.feign")
public class SentinelOpenfeign8087Application {

    public static void main(String[] args) {
        SpringApplication.run(SentinelOpenfeign8087Application.class, args);
    }

}
