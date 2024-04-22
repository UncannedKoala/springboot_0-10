package com.learining.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

//	works for http://localhost:8080/
	@RequestMapping
	public String home() {
		return "home.html";
	}

//	works for http://localhost:8080/home
	@RequestMapping("/home")
	public String home2() {
		return "home2.html";
	}

//	works for http://localhost:8080/requestParam1?requestParameter=testReqParam
//	case-insensitive :: case-sensivity is ignored and even with wrong case the action method is found
	@RequestMapping("/requestParam1")
	public String requestParam1(@RequestParam String requestParameter) {
		System.err.println("requestParam1: " + requestParameter);
		return "home.html";
	}

//	works for http://localhost:8080/requestParam2?parameter1=abc&parameter2=xyz
	@RequestMapping("/requestParam2")
	public String requestParam2(@RequestParam(required = false) String parameter1, @RequestParam String parameter2) {
		System.err.println("requestParam2: " + parameter1 + ", " + parameter2);
		return "home.html";
	}

//	works for http://localhost:8080/requestParam2?parameter1=abc&parameter2=xyz
//	case-sensitive
	@RequestMapping("/pathParam1/{var}")
	public String pathParam1(@PathVariable int var) {
		System.err.println("pathParam1: " + var);
		return "home2.html";
	}

//	works for http://localhost:8080/pathParam2/20/50
//  can't return a string or html page like previously done, when using @PathVariable
	@RequestMapping("/pathParam2/{num1}/{num2}")
	public ResponseEntity<String> pathParam2(@PathVariable int num1, @PathVariable int num2) {
		System.err.println("pathParam2: " + (num1 + num2));
		return ResponseEntity.ok("" + (num1 + num2));
//		return "home.html";		// can't return a string or html page like previously done
	}
	
	

}
