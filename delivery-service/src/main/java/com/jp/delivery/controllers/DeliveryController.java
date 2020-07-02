package com.jp.delivery.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

	@RequestMapping(value = "/deliveryServices", method = RequestMethod.GET)
	public String displayAllDeliveredOrders() {
		return "All delivered Orders";
	}
}
