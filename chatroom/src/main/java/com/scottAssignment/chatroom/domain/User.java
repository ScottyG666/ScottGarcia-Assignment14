package com.scottAssignment.chatroom.domain;

public class User {

	private Long id;
	private String designation;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", designation=" + designation + "]";
	}
	
	
	
	
	
}
