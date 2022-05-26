package com.scottAssignment.chatroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.scottAssignment.chatroom.repository.ChannelRepository;

@Component
public class Initializer implements CommandLineRunner{
	
	@Autowired
	private ChannelRepository channelrepo;

	@Override
	public void run(String... args) throws Exception {
		Channel generalChannel = new Channel();
		
		generalChannel.setId(1L);
		
		generalChannel.setChannelName("Channel_General");
		
		/*
		 *		This code is unnecessary and will probably be deleted later	 
		 */
		
		generalChannel.getMessages().add(new ChatMessage());
		
		generalChannel.getMessages().get(0).setSentBy(new User());
		
		generalChannel.getMessages().get(0).getSentBy().setDesignation(("Administration"));
		generalChannel.getMessages().get(0).getSentBy().setId(1L);
		generalChannel.getMessages().get(0).setContext("Welcome to the chat! please feel free to enter a message!");
		
		
		channelrepo.saveChannel(generalChannel);
	}

}