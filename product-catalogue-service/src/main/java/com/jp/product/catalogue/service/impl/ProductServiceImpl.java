package com.jp.product.catalogue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.product.catalogue.entity.Product;
import com.jp.product.catalogue.enums.Brand;
import com.jp.product.catalogue.enums.Color;
import com.jp.product.catalogue.enums.Size;
import com.jp.product.catalogue.repository.ProductRepository;
import com.jp.product.catalogue.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public void deleteProduct(int productID) {
		productRepository.deleteById(productID);

	}

	@Override
	public Product updateProduct(Product product) {
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public Product getProductById(int productID) {
		return productRepository.getOne(productID);
	}

	@Override
	public Product getProductByBrand(Brand brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public Product getProductByColor(Color color) {
		return productRepository.findByColor(color);
	}

	@Override
	public Product getProductBySize(Size size) {
		return productRepository.findBySize(size);
	}

	@Override
	public Product getProductByPrice(double price) {
		return productRepository.findByPrice(price);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByQuery(Brand brand, Color color, Size size, double price) {

		return null;
	}

	public List<Product> getProductByQuery(String brand, String color, String size, double price) {

		return null;
	}

	@Override
	public void deleteAllProducts() {
		productRepository.deleteAll();

	}

}
