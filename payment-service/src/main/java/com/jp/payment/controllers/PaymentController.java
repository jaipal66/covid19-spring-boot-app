package com.jp.payment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {
	private static final Logger LOGGER=LoggerFactory.getLogger(PaymentController.class);

	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public String displayAllPayments() {
		LOGGER.info("displayAllPayments is called");
		return "All Payments";
	}

}
