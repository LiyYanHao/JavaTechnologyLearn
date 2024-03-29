package com.example.sentinel8084;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8084Application {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel8084Application.class, args);
    }

}
