package com.learining.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.learining.springboot.model.Cat;
import com.learining.springboot.model.Person;

@Configuration
public class BaseConfig {

	@Bean
	Cat p1() {
		return new Cat("Kitty", 0);
	}

	/*
	 * p1() invocation will return the same Cat that is present in the context as
	 * opposed to a new one
	 */
	@Bean
	@Primary
	Person properPerson() {
		return new Person("default name", 0, p1());
	}

}
