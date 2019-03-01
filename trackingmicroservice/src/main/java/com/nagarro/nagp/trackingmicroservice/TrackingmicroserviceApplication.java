package com.nagarro.nagp.trackingmicroservice;

import com.nagarro.nagp.trackingmicroservice.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TrackingmicroserviceApplication {

    @Autowired
    TrackingService trackingService;

    public static void main(String[] args) {
        SpringApplication.run(TrackingmicroserviceApplication.class, args);
    }

}
