package com.learining.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learining.springboot.service.LoggedUserManagementService;

@Controller
public class MainController {

	private LoggedUserManagementService loggedUserManagementService;

	public MainController(LoggedUserManagementService loggedUserManagementService) {
		super();
		this.loggedUserManagementService = loggedUserManagementService;
	}

	@GetMapping("/main")
	public String home(@RequestParam(required = false) String logout, Model model) {
		String userName = this.loggedUserManagementService.getUserName();
		
		if (logout != null)
			loggedUserManagementService.setUserName(null);
		
		if (userName == null)
			return "redirect:/";
		
		model.addAttribute("userName", userName);
		return "main.html";
	}
}
