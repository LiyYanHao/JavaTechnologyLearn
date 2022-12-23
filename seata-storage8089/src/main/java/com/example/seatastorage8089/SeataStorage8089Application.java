package com.example.seatastorage8089;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan({"com.example.seatastorage8089.dao"})
public class SeataStorage8089Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorage8089Application.class, args);
    }

}
