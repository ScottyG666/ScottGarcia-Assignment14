package com.scottAssignment.chatroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.scottAssignment.chatroom.repository.ChannelRepository;

@Component
public class Initializer implements CommandLineRunner{
	
	@Autowired
	private ChannelRepository channelrepo;

	/*
	 * This code initializes a General chat channel so that a default room is available
	 * 	upon startup and doesnt need to be created
	 */
	@Override
	public void run(String... args) throws Exception {
		Channel generalChannel = new Channel();
		generalChannel.setId(1L);
		generalChannel.setChannelName("Channel_General");
		channelrepo.saveChannel(generalChannel);
	}

}
