package com.myfirstproject.util;

public enum UserRole {
	ROLE_ADMIN("Admin"), ROLE_USER("User"), ROLE_SELLER("Seller");
	
	UserRole(String description){
		this.description = description;
	}
	
	private String name;
	private String description;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
