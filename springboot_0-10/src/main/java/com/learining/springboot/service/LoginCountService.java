package com.learining.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
	
	private long counter;
	
	public LoginCountService() {
		super();
		this.counter = 0l;
	}

	public void increment() {
		counter++;
	}
	
	public long getCounter() {
		return this.counter;
	}
}
