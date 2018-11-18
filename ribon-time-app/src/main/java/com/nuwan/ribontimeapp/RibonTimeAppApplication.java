package com.nuwan.ribontimeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nuwan.ribontimeapp.config.RibbonTimeConfig;

@RestController
@SpringBootApplication
@RibbonClient(name="time-service",configuration=RibbonTimeConfig.class)
public class RibonTimeAppApplication {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RibonTimeAppApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@GetMapping
	public String listTime() {
		return restTemplate.getForEntity("http://time-service", String.class).getBody();
	}
}
