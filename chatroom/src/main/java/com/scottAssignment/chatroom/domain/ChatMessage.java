package com.scottAssignment.chatroom.domain;

import org.springframework.stereotype.Component;

@Component
public class ChatMessage {
	
	public ChatMessage () {}
	
	public ChatMessage (User user, String message) {
		this.sentBy = user;
		this.context = message;
	}
	
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

	@Override
	public String toString() {
		return "ChatMessage [sentBy=" + sentBy + ", context=" + context + "]";
	}
	
	

}
