package com.example.sentinelopenfeign8086;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.sentinelopenfeign8086.feign")
public class SentinelOpenfeign8086Application {

    public static void main(String[] args) {
        SpringApplication.run(SentinelOpenfeign8086Application.class, args);
    }

}
