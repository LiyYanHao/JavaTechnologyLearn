package com.example.seataorder8088;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan({"com.example.seataorder8088.dao"})
@EnableFeignClients
@SpringBootApplication
@EnableAutoDataSourceProxy
public class SeataOrder8088Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrder8088Application.class, args);
    }

}
