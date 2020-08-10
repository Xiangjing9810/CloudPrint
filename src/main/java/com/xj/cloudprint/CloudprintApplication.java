package com.xj.cloudprint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(basePackages = "com.xj.cloudprint.mapper")
public class CloudprintApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CloudprintApplication.class, args);
    }

}
