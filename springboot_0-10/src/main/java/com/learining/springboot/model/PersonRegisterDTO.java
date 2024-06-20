package com.learining.springboot.model;

import java.util.Objects;

import org.springframework.stereotype.Component;

//@Component
public class PersonRegisterDTO {

	private String name;
	private int age;
	private Cat pet;

	public PersonRegisterDTO() {
		super();
	}

	public PersonRegisterDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public PersonRegisterDTO(String name, int age, Cat pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	public Cat getPet() {
		return pet;
	}

	public void setPet(Cat pet) {
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, pet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonRegisterDTO other = (PersonRegisterDTO) obj;
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(pet, other.pet);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}

}
