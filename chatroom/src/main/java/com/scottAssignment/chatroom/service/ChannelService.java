package com.scottAssignment.chatroom.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottAssignment.chatroom.domain.Channel;
import com.scottAssignment.chatroom.domain.ChatMessage;
import com.scottAssignment.chatroom.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepo;

	public List<Channel> retreiveAllChannels() {
		
		return channelRepo.getChannelList().entrySet()
										   .stream()
										   .map(Map.Entry::getValue)
										   .collect(Collectors.toList());
 
	}

	public void createNewChannel() {
	channelRepo.createNewChannel();
	}

	public Channel getChannelById(Long channelId) {

		return channelRepo.getChannelById(channelId);
	}

	public void addMessageToChannel(Long channelId, ChatMessage chatMessage) {

		channelRepo.addMessageToChannel(channelId, chatMessage);
	}

}
