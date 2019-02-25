package com.nagarro.nagpassignment.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrdermicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermicroserviceApplication.class, args);
	}

}
