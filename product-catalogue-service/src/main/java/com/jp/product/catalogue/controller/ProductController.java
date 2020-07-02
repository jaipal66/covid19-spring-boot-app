package com.jp.product.catalogue.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.product.catalogue.constant.ProductApiConstant;
import com.jp.product.catalogue.entity.Product;
import com.jp.product.catalogue.enums.Brand;
import com.jp.product.catalogue.enums.Color;
import com.jp.product.catalogue.enums.Size;
import com.jp.product.catalogue.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Product Catalouge Search System")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "View a Product based on product id ", response = Product.class)
	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	@RequestMapping(value = ProductApiConstant.PRODUCT_ID_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Product getProductById(@PathVariable int productID) {
		return productService.getProductById(productID);
	}

	@ApiOperation(value = "View all available Products", response = List.class)
	@RequestMapping(value = ProductApiConstant.BASE_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts(
			@ApiParam(value = "Query param for 'brand' filter") @Valid @RequestParam(value = "brand", required = false) String brand,
			@ApiParam(value = "Query param for 'color' filter") @Valid @RequestParam(value = "color", required = false) String color,
			@ApiParam(value = "Query param for 'size' filter") @Valid @RequestParam(value = "size", required = false) String size,
			@ApiParam(value = "Query param for 'price' filter") @Valid @RequestParam(value = "price", required = false) double price,
			@ApiParam(value = "Query param for 'pageNumber'") @Valid @RequestParam(value = "pageNumber", required = false, name = "pageNumber", defaultValue = "0") int pageNumber,
			@ApiParam(value = "Query param for 'pageSize'") @Valid @RequestParam(value = "pageSize", required = false, name = "pageSize", defaultValue = "10") int pageSize,
			@ApiParam(value = "Query param for 'sort' criteria") @Valid @RequestParam(value = "sort", required = false) String sort) {
		return productService.getProductByQuery(Brand.valueOf(brand), Color.valueOf(color), Size.valueOf(size), price);
	}
	@ApiOperation(value = "Create Product", response = Product.class)
	@RequestMapping(value = ProductApiConstant.BASE_URI, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@RequestMapping(value = ProductApiConstant.BRAND_NAME_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Product getProductByBrand(@PathVariable String brandName) {
		return productService.getProductByBrand(Brand.valueOf(brandName));
	}

	@RequestMapping(value = ProductApiConstant.COLOR_NAME_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Product getProductByColor(@PathVariable String color) {
		return productService.getProductByColor(Color.valueOf(color));
	}

	@RequestMapping(value = ProductApiConstant.SIZE_NAME_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Product getProductBySize(@PathVariable String size) {
		return productService.getProductBySize(Size.valueOf(size));
	}

	@RequestMapping(value = ProductApiConstant.PRICE_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Product getProductByColor(@PathVariable double price) {
		return productService.getProductByPrice(price);
	}

	@ApiOperation(value = "Update Product", response = Product.class)
	@RequestMapping(value = ProductApiConstant.BASE_URI, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	@ApiOperation(value = "Delete Product based on ProductID", response = Void.class)
	@RequestMapping(value = ProductApiConstant.PRODUCT_ID_URI, method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int productID) {
		productService.deleteProduct(productID);
	}
	@ApiOperation(value = "Delete All Products", response = Void.class)
	@RequestMapping(value = ProductApiConstant.BASE_URI, method = RequestMethod.DELETE)
	public void deleteAllProducts() {
		productService.deleteAllProducts();
	}

}
