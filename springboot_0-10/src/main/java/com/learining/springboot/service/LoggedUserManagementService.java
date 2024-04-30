package com.learining.springboot.service;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {

	private String userName;

	public LoggedUserManagementService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoggedUserManagementService(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "LoggedUserManagementService [userName=" + userName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoggedUserManagementService other = (LoggedUserManagementService) obj;
		return Objects.equals(userName, other.userName);
	}

}
