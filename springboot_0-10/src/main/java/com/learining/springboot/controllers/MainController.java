package com.learining.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learining.springboot.service.LoggedUserManagementService;
import com.learining.springboot.service.LoginCountService;

@Controller
public class MainController {
	
	private LoggedUserManagementService loggedUserManagementService;
	private LoginCountService loginCountService;

	public MainController(LoggedUserManagementService loggedUserManagementService) {
		super();
		this.loggedUserManagementService = loggedUserManagementService;
	}

	@GetMapping("/main")
	public String home(
			@RequestParam(required = false) String logout, 
			Model model
			) {
		
		if (logout != null)
			loggedUserManagementService.setUserName(null);
		
		String userName = this.loggedUserManagementService.getUserName();
		long counter = loginCountService.getCounter();
		
		if (userName == null)
			return "redirect:/";
		
		model.addAttribute("userName", userName);
		model.addAttribute("loginCount", counter);
		
		return "main.html";
	}
}
