package com.orhanararat.courier.tracking.distance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CourierServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourierServiceApplication.class, args);
    }
}
