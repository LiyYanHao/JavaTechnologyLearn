package com.lyh.nacosconfig9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class NacosConfig9001Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig9001Application.class, args);
    }

}
