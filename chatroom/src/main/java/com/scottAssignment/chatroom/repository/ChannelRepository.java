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
		newChannel.setId( Integer.valueOf(channelList.size()).longValue() + 1);
		
		channelList.put(newChannel.getId(), newChannel);
			}
	//updated to use Map
	public void addMessageToChannel(Long channelId, ChatMessage chatMessage) {
		channelList.get(channelId).getMessages().add(chatMessage);
		
	}
	
	
}
