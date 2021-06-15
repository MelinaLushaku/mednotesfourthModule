package com.example.mednotes4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mednotes4Application {

    public static void main(String[] args) {
        SpringApplication.run(Mednotes4Application.class, args);
    }

}
