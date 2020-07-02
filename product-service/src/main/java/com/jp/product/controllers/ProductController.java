package com.jp.product.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String displayAllProducts() {
		return "All products";
	}
}
