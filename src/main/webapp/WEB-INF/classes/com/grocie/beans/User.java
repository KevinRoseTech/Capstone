package com.grocie.beans;

import java.util.UUID;

public class User {
	
	private UUID id;
	private String fullName;
	private String password;
	
	public User(String fullName, String password){
		this.fullName = fullName;
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
