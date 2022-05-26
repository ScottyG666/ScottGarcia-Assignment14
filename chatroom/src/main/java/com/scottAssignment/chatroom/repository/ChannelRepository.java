package com.scottAssignment.chatroom.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.scottAssignment.chatroom.domain.Channel;

@Repository
public class ChannelRepository {
	List<Channel> channelList = new ArrayList<>();

	public List<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<Channel> channelList) {
		this.channelList = channelList;
	}
	
	public Channel saveChannel(Channel channel) {
		channelList.add(channel);
		return channel;
	}

	public void createNewChannel() {
		Channel newChannel = new Channel();
		newChannel.setChannelName("Channel #" + channelList.size());
		newChannel.setId( Integer.valueOf(channelList.size()).longValue());
		channelList.add(newChannel);
			}

	public Channel getChannelById(Long channelId) {

		return channelList.get(Long.valueOf(channelId).intValue() - 1);
	}
	
	
}
