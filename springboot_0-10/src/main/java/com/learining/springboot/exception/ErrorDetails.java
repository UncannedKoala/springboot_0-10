package com.learining.springboot.exception;

public class ErrorDetails extends Exception {

	public ErrorDetails() {
	}

	public ErrorDetails(String str) {
		super(str);
	}
}
