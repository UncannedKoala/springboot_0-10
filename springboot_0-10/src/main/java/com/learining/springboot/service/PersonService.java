package com.learining.springboot.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;

import com.learining.springboot.exceptions.PersonNotFoundException;
import com.learining.springboot.model.Person;

@Service
public class PersonService {

	private GenericApplicationContext ctxt;

	@Autowired
	public PersonService(GenericApplicationContext ctxt) {
		this.ctxt = ctxt;
	}

	public Person getPersonFromContext(String name) {
		Map<String, Person> map = ctxt.getBeansOfType(Person.class);
		System.out.println(map);
		Person p = new Person();
		map.entrySet().parallelStream().filter(entry -> entry.getValue().getName().equalsIgnoreCase(name)).findAny()
				.ifPresent(entry -> {
					Person temp = entry.getValue();
					p.setName(temp.getName());
					p.setAge(temp.getAge());
					p.setPet(temp.getPet());
				});
		if (p.getName() == null) {
			throw new PersonNotFoundException();
		}
		return p;
	}
}
