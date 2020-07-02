package com.jp.bus.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = { "com.jp.bus.booking.app" })
@EnableTransactionManagement
@EnableJpaRepositories
public class BusBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingServiceApplication.class, args);
	}

}
