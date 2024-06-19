package com.learining.springboot.model;

public interface Pet {

	public default Object eat() {
		System.out.println("Pet.eat()");
		return this;
	};

	public default Object sleep() {
		System.out.println("Pet.sleep()");
		return this;
	};
}
