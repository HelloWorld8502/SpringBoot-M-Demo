package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description: 主启动类
 * @author: root
 * @date: 2021/6/16 23:26
 * @version: v1.0
 */
@SpringBootApplication
@MapperScan(value = "com.test.mapper")
@EnableAsync
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
