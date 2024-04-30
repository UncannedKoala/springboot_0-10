package com.learining.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learining.springboot.processors.LoginProcessor;

@Controller
public class LoginController {

	@GetMapping("/")
	public String loginGet() {
		return "login.html";
	}

	@PostMapping("/")
	public String loginPost(@RequestParam String username, @RequestParam String password, Model model,
			LoginProcessor loginProcessor) {
		loginProcessor.setUser(username);
		loginProcessor.setPassword(password);
		boolean loggedIn = loginProcessor.login();
		if (loggedIn) {
			return "redirect:/main";
		}
		model.addAttribute("message", "Login failed!");
		return "login.html";
	}
}
