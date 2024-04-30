package com.learining.springboot.processors;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.learining.springboot.service.LoggedUserManagementService;
import com.learining.springboot.service.LoginCountService;

/***
 * for each request the setters are called and the values from the request are
 * set based on name of the parameters-variable names
 */
@Component
@RequestScope
public class LoginProcessor {

	private final LoggedUserManagementService loggedUserManagementService;
	private final LoginCountService loginCountService;
	
	private String user;
	private String password;

	public LoginProcessor(
			LoggedUserManagementService loggedUserManagementService, 
			LoginCountService loginCountService) {
		super();
		this.loggedUserManagementService = loggedUserManagementService;
		this.loginCountService = loginCountService;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoggedUserManagementService getLoggedUserManagementService() {
		return loggedUserManagementService;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loggedUserManagementService, password, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginProcessor other = (LoginProcessor) obj;
		return Objects.equals(loggedUserManagementService, other.loggedUserManagementService)
				&& Objects.equals(password, other.password) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "LoginProcessor [loggedUserManagementService=" + loggedUserManagementService + ", user=" + user
				+ ", password=" + password + "]";
	}

	public boolean login() {
		loginCountService.increment();
		String userName = this.getUser();
		String password = this.getPassword();

		System.err.println(userName + ", " + password);
		boolean loginResult = false;
		if ("natlie".equals(userName) && "password".equals(password)) {
			loginResult = true;
			loggedUserManagementService.setUserName(userName);
		}
		return loginResult;
	}

}
