package com.example.openfeignconsumer8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.openfeignconsumer8083.feign")
public class OpenfeignConsumer8083Application {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignConsumer8083Application.class, args);
    }

}
