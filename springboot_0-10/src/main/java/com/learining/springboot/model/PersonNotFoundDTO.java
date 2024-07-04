package com.learining.springboot.model;

public class PersonNotFoundDTO {
	private String cause;

	public PersonNotFoundDTO(String cause) {
		this.cause = cause;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		return "PersonNotFoundDTO [cause=" + cause + "]";
	}
}
