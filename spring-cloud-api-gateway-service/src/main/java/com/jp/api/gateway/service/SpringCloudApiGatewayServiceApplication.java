package com.jp.api.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class SpringCloudApiGatewayServiceApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(SpringCloudApiGatewayServiceApplication.class);
	public static void main(String[] args) {
		LOGGER.info("api gateway started");
		SpringApplication.run(SpringCloudApiGatewayServiceApplication.class, args);
	}

}
