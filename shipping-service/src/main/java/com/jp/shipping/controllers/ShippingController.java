package com.jp.shipping.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

	@RequestMapping(value="/shippingServices",method=RequestMethod.GET)
	public String displayAllShippedOrders() {
		return "All Shipped Orders";
	}
}

