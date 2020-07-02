package com.jp.product.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.product.catalogue.entity.Product;
import com.jp.product.catalogue.enums.Brand;
import com.jp.product.catalogue.enums.Color;
import com.jp.product.catalogue.enums.Size;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findByBrand(Brand brand);
	Product findByColor(Color color);
	Product findBySize(Size size);
	Product findByPrice(double price);
	/*
	 * @Query("select * from products") public List<Product> getProductByQuery(Brand
	 * brand,Color color,Size size,double price);
	 */
	

}
