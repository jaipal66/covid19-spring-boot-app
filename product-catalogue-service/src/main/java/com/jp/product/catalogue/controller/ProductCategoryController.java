package com.jp.product.catalogue.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.product.catalogue.entity.ProductCategory;

@RestController
public class ProductCategoryController {

	@RequestMapping(value = "/productCategories", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
		return null;
	}

	@RequestMapping(value = "/productCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<ProductCategory> displayAllProductCategory() {
		return null;
	}

	@RequestMapping(value = "/productCategories/{categoryID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ProductCategory displayProductCategoryById(@PathVariable int categoryID) {
		return null;
	}

	@RequestMapping(value = "/productCategories", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
		return null;
	}

	@RequestMapping(value = "/productCategories/{categoryID}", method = RequestMethod.DELETE)
	public ProductCategory deleteProductCategoryById(@PathVariable int categoryID) {
		return null;
	}

	@RequestMapping(value = "/productCategories", method = RequestMethod.DELETE)
	public void deleteAllProductCategory() {
		return;
	}

}
