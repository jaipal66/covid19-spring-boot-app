package com.jp.bus.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BusBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingServiceApplication.class, args);
	}

}
