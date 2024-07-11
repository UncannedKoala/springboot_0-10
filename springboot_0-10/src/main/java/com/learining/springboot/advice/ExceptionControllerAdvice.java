package com.learining.springboot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learining.springboot.exception.ErrorDetails;
import com.learining.springboot.exception.NotFound;
import com.learining.springboot.exception.PersonNotFoundException;

//@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<NotFound> notFoundExceptionHandler(){
		PersonNotFoundException err = new PersonNotFoundException("Person not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
