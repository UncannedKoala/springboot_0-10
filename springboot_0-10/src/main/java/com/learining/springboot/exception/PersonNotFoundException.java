package com.learining.springboot.exception;

public class PersonNotFoundException extends ErrorDetails implements NotFound {

	public PersonNotFoundException() {
	}

	public PersonNotFoundException(String str) {
		super(str);
	}
}
