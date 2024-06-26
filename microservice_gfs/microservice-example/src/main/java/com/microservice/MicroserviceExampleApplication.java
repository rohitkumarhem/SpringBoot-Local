package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExampleApplication.class, args);
	}
	

}
