package com.moma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MomaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MomaApplication.class, args);
    }

}

