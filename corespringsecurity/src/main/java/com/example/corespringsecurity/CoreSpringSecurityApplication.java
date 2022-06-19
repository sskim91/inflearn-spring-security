package com.example.corespringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CoreSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreSpringSecurityApplication.class, args);
    }

}
