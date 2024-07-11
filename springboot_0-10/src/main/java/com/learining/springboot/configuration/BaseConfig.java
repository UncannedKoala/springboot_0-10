package com.learining.springboot.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import com.learining.springboot.model.Cat;
import com.learining.springboot.model.Person;

@Configuration
@EnableFeignClients(basePackages = "com.learining.springboot.proxy")
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
	
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
