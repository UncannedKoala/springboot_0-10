package com.learining.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

//	works for http://localhost:8080/
	@RequestMapping("/home1")
	public String home1() {
		return "home.html";
	}

//	works for http://localhost:8080/home
	@RequestMapping("/home2")
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
	
//	works for http://localhost:8080/template1/abc/xyz
	@RequestMapping("/template1/{val1}/{val2}")
	public String template1(@PathVariable String val1, @PathVariable String val2, Model model) {
		System.out.println("template1: " + val1 + " " + val2);
		model.addAttribute("val1", val1);
		model.addAttribute("val2", val2);
		return "template1";
	}
	
//	works for http://localhost:8080/template2/blue/blue
	@RequestMapping("/template2/{text}/{color}")
	public String template2(@PathVariable String text, @PathVariable String color, Model model) {
		model.addAttribute("text", text);
		model.addAttribute("textColor", color);
		return "colorTemplate";
	}

}
