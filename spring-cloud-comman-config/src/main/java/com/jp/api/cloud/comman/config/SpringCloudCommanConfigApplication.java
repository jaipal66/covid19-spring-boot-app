package com.jp.api.cloud.comman.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class SpringCloudCommanConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCommanConfigApplication.class, args);
	}

}
