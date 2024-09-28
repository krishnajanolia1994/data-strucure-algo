package com.example.krishna.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayApplication.class, args);
		
		var r="jhdfj";
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("path_route1", r -> r.path("http://localhost:8089/client/*")
				.uri("http://localhost:8081/*"))
			.route("path_route", r -> r.path("http://localhost:8089/client1/*")
				.uri("http://localhost:8082/*"))
			
			.build();
	}

}
