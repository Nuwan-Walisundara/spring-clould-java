package com.nuwan.ribontimeserver;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class RibonTimeServerApplication {

	@Value("${server.port}")
	private String port;
	
	public static void main(String[] args) {
		SpringApplication.run(RibonTimeServerApplication.class, args);
	}

	@RequestMapping
	public String getTime() {
		return "The current time: " + new Date().toString()
				+ "answerd By port " + port ;
	}
}
