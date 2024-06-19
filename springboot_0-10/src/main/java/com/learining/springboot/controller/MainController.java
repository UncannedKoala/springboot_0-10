package com.learining.springboot.controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learining.springboot.model.Cat;
import com.learining.springboot.model.Person;

@RestController
public class MainController {

	@Autowired
	private ApplicationContext ctxt;

//	http://localhost:8080/wish
	@GetMapping("/wish")
	public String wish() {
		return "hello";
	}

//	http://localhost:8080/greet?name=%20Piyush
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "hey" + name;
	}

//	http://localhost:8080/person
	@Autowired
	@GetMapping("/person")
	public Person person(Person properPerson, Cat p1) {
		System.out.println(ctxt.getBean("Person"));
		return ctxt.getBean(Person.class);
	}

	/**
	 * API to return An instance in a response body
	 * 
	 * @param name name value of Person instance
	 * @param age  age value of the Person instance
	 * @return
	 *         <li>Person instance with valid passed values
	 *         <li>default Person instance if any of the values is invalid, example
	 *         for http://localhost:8080/person/%20/10
	 */
	@GetMapping("/person/{name}/{age}")
	public Optional<Person> personOf(@PathVariable String name, @PathVariable int age) {
		Optional<Person> person = Optional.of(new Person("default name", 0));
		if (name.isBlank() || age < 0)
			return person;
		return Optional.of(new Person(name, age));
	}

	/**
	 * other version of above API
	 * 
	 * @param name name value of Person instance
	 * @param age  age value of the Person instance
	 * @return A Person instance with valid values, else a default Person instance
	 */
	@GetMapping("/person2/{name}/{age}")
	public Person personOf2(@PathVariable String name, @PathVariable int age) {
		Optional<Person> person = Optional.empty();
		if (name.isBlank() || age < 0)
			person = Optional.of(new Person("default name", 0));
		return person.orElse(new Person(name, age));
	}

	/**
	 * Person[], List<Person>, Set<Person>, Collection<Person> would result the same
	 * 
	 * @return An array of Persons
	 */
	@GetMapping("/persons")
	public Person[] persons() {
		return Stream.of(new Person("Person1", 11), new Person("Person2", 27)).toArray(length -> new Person[length]);
//		return List.of(new Person("Person1", 11), new Person("Person2", 27));
	}

	/**
	 * <li>Demonstrating control over the 'http response' using
	 * 'ResponseEntity'</li>
	 * <li>Custom Headers that are returned are visible under the 'chrome dev tools'
	 * headers in 'raw' options</li>
	 */
	@GetMapping("/chad")
	public ResponseEntity<Person> chad() {
		Person chad = new Person("Chad", 31);
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).header("skin color complexion", "fair")
				.header("eye color", "hazel").body(chad);
	}

}
