package com.jp.spring.cloud.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class SpringCloudApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(SpringCloudApplication.class);

	public static void main(String[] args) {
		LOGGER.info("started hystrix dashboard");
		SpringApplication.run(SpringCloudApplication.class, args);
	}

}
