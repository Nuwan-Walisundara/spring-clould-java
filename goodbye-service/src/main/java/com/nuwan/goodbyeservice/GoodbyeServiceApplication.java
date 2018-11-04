package com.nuwan.goodbyeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class GoodbyeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodbyeServiceApplication.class, args);
	}
	
	@RequestMapping
	public String goodBye() {
		return "Good Bye";
	}
}
