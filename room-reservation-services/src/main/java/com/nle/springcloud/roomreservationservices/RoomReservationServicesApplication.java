package com.nle.springcloud.roomreservationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RoomReservationServicesApplication {

// using Feign auto enable Ribbon load balancer no need to use rest template -> using RoomClient (FeignClient) instead
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(RoomReservationServicesApplication.class, args);
	}

}
