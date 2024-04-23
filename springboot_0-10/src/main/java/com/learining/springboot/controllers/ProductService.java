package com.learining.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.learining.springboot.model.Product;

@Service
public class ProductService {
	
	private List<Product> products = new ArrayList<>();
	
	public void addProducts(Product product) {
		Objects.requireNonNull(product);
		products.add(product);
	}
	
	/**
	 * returns a copy of products
	 */
	public List<Product> findAll() {
		return products.stream().toList();
	}
}
