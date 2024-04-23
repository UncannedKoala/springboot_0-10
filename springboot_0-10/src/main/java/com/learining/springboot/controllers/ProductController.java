package com.learining.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learining.springboot.model.Product;

@Controller
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/products")
	public String getProducts(Model model) {
		var products = service.findAll();
		model.addAttribute("products", products);
		return "products.html";
	}
	
	@PostMapping("/products")
	public String addProduct(@RequestParam String name, @RequestParam double cost, Model model) {
		var product = new Product(name, cost);
		service.addProducts(product);
		
		var products = service.findAll();
		model.addAttribute("products", products);
		
		return "products.html";
	}
}
