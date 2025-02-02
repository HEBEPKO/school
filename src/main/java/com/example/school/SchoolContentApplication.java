package com.example.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.school.*")
//@EntityScan("com.example.school.*")
public class SchoolContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolContentApplication.class, args);
    }

}