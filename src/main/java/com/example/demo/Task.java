package com.example.demo;

import org.springframework.data.annotation.Id;

public class Task {
	
	Long id;
	String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Task(String description) {
		super();
		this.description = description;
	}
	public Task(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
}
