package com.learining.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// works for http://localhost:8080/
	@RequestMapping
	public String home() {
		return "home.html";
	}

	// works for http://localhost:8080/home
	@RequestMapping("/home")
	public String home2() {
		return "home2.html";
	}
}
