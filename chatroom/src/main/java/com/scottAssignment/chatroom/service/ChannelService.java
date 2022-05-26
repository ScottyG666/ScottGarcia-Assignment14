package com.scottAssignment.chatroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottAssignment.chatroom.domain.Channel;
import com.scottAssignment.chatroom.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepo;

	public List<Channel> retreiveAllChannels() {
		
		List<Channel> channelList = channelRepo.getChannelList();
 
		return channelList;
	}

	public void createNewChannel() {
	channelRepo.createNewChannel();
	}

	public Channel getChannelById(Long channelId) {

		return channelRepo.getChannelById(channelId);
	}

}
