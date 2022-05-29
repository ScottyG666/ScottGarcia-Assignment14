package com.scottAssignment.chatroom.domain;

import org.springframework.stereotype.Component;

@Component
public class User {

	private Long userId;
	private String designation;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", designation=" + designation + "]";
	}
	
	
	
	
}
