package com.scottAssignment.chatroom.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.scottAssignment.chatroom.domain.Channel;
import com.scottAssignment.chatroom.domain.ChatMessage;

@Repository
public class ChannelRepository {
	
	Map<Long, Channel> channelList = new LinkedHashMap<>();
	
	public Map<Long, Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(Map<Long, Channel> channelList) {
		this.channelList = channelList;
	}
	

	//adjusted to take advantage of the MAP
	public Channel saveChannel(Channel channel) {
		channelList.put(channel.getId(), channel);			

		return channel;
	}
	
	//changed to take advantage of MAP
	public Channel getChannelById(Long channelId) {

		return channelList.get(channelId);
	}

	//Updated to use Map
	public void createNewChannel() {
		Channel newChannel = new Channel();
		newChannel.setChannelName("Channel #" + channelList.size());
		newChannel.setId( Integer.valueOf(channelList.size()).longValue());
		
		channelList.put(newChannel.getId(), newChannel);
			}
	//updated to use Map
	public void addMessageToChannel(Long channelId, ChatMessage chatMessage) {
		channelList.get(channelId).getMessages().add(chatMessage);
		
	}
	
	
	
	
	//**********METHODS BELOW THIS ARE LEGACY FROM USING ARRAYLIST INSTEAD OF MAP********
	
	/*
	
	private List<Channel> channelList = new ArrayList<>();
	
	public List<Channel> getChannelList() {
		return channelList;
	}
	
	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	
	
	public void createNewChannel() {
		Channel newChannel = new Channel();
		newChannel.setChannelName("Channel #" + channelList.size());
		newChannel.setId( Integer.valueOf(channelList.size()).longValue());
		channelList.add(newChannel);
	}
	
	public Channel saveChannel(Channel channel) {
		channelList.add(channel);
		return channel;
	}
	
	
	
	
	
	//method using the array list *TO BE UPDATED TO USER MAP*
	public Channel getChannelById(Long channelId) {

		return channelList.get(Long.valueOf(channelId).intValue() - 1);
	}
	*/
	
}
