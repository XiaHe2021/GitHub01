package com.turing.sb5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.turing.sb5.mapper")
public class Sb5Application {
    public static void main(String[] args) {
        SpringApplication.run(Sb5Application.class, args);
    }

}
