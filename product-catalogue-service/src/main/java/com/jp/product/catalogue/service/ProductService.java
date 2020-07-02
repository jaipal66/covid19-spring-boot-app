package com.jp.product.catalogue.service;

import java.util.List;

import com.jp.product.catalogue.entity.Product;
import com.jp.product.catalogue.enums.Brand;
import com.jp.product.catalogue.enums.Color;
import com.jp.product.catalogue.enums.Size;

public interface ProductService {
	
	public Product addProduct(Product product);
	public void deleteProduct(int productID);
	public Product updateProduct(Product product);
	public Product getProductById(int productID);
	public Product getProductByBrand(Brand brand);
	public Product getProductByColor(Color color);
	public Product getProductBySize(Size size);
	public Product getProductByPrice(double price);
	public List<Product> getAllProducts();
	public List<Product> getProductByQuery(Brand brand,Color color,Size size,double price);
	public void deleteAllProducts();
	
	
	

}
