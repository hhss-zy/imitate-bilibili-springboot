package com.example.shixun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@ComponentScans(value = {@ComponentScan("com.example.shixun.shixun.entity"),
        @ComponentScan("com.example.shixun.shixun.controller"),
        @ComponentScan("com.example.shixun.shixun.service.impl"),
})
@MapperScan("com.example.shixun.shixun.mapper")
@SpringBootApplication
public class ShixunApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShixunApplication.class, args);
    }

}
