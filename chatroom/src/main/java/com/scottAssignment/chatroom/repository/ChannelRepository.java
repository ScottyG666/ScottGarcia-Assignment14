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
	
	
	
}
