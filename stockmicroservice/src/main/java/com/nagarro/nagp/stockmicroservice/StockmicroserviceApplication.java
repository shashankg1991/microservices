package com.nagarro.nagp.stockmicroservice;

import com.nagarro.nagp.stockmicroservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockmicroserviceApplication {

    @Autowired
    StockService stockService;

    public static void main(String[] args) {
        SpringApplication.run(StockmicroserviceApplication.class, args);
    }

}
