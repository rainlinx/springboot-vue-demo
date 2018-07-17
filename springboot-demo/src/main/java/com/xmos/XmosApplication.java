package com.xmos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xmos.repository")
@SpringBootApplication
public class XmosApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmosApplication.class, args);
    }
}
