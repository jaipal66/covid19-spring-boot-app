package com.jp.order.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String displayAllOrders() {
		return "All Orders";
	}

	@RequestMapping(value = "/orders/{orderID}", method = RequestMethod.GET)
	public String displayOrderById(@PathVariable String orderID) {
		
		return orderID+" is being procced";

	}

	public void createOrder() {

	}

	public void updateOrder() {

	}

	public void deleteOrder() {

	}
}
