package com.jp.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomLoggingSpringBootAppApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomLoggingSpringBootAppApplication.class);

	public static void main(String[] args) {
		LOGGER.warn("logger warning");
		LOGGER.info("logger info");
		LOGGER.debug("logger debug");
		LOGGER.error("logger error");
		SpringApplication.run(CustomLoggingSpringBootAppApplication.class, args);
	}

}
