package com.example.seataaccount8100;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan({"com.example.seataaccount8100.dao"})
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccount8100Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccount8100Application.class, args);
    }

}
