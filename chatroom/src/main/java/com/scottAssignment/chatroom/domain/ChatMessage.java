package com.scottAssignment.chatroom.domain;

import org.springframework.stereotype.Component;

@Component
public class ChatMessage {
	
	private User sentBy;
	private String context;
	
	
	public User getSentBy() {
		return sentBy;
	}
	public void setSentBy(User sentBy) {
		this.sentBy = sentBy;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	

}
