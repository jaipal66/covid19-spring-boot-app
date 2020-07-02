package com.jp.api.gateway.service.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	@RequestMapping(value="/orderServiceFallback")
	public String orderServiceFallback() {
		return "Order service is taking too long or its down";
	}
	
	@RequestMapping(value="/shippingServiceFallback")
	public String shippingServiceFallback() {
		return "Shipping service is taking too long or its down";
	}
	
	@RequestMapping(value="/paymentServiceFallback")
	public String paymentServiceFallback() {
		return "Payment service is taking too long or its down";
	}
	
	@RequestMapping(value="/deliveryServiceFallback")
	public String deliveryServiceFallback() {
		return "Delivery service is taking too long or its down";
	}
	
	@RequestMapping(value="/productServiceFallback")
	public String productServiceFallback() {
		return "Product service is taking too long or its down";
	}

}
