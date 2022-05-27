package com.scottAssignment.chatroom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.scottAssignment.chatroom.domain.Channel;
import com.scottAssignment.chatroom.domain.ChatMessage;
import com.scottAssignment.chatroom.domain.User;
import com.scottAssignment.chatroom.service.ChannelService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;

	
	/*	Figure out how to pass the user from the postRegister into this 
	 * GetMapping!!!
	 */
	@GetMapping("/channels")
	public String getChannels(ModelMap model) {
		model.put("channelsView", channelService.retreiveAllChannels());
		return "channels";
	}
	
	@PostMapping("channels/createChannel")
	public String createAccount () {
		channelService.createNewChannel();
		
		
		return "redirect:/channels";
	}
	
	@GetMapping("/channels/{channelId}")
	public String getChannelDisplay (ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.getChannelById(channelId);
		model.put("chatroom", channel);
		model.put("user", new User());
		model.put("chatMessage", "");
		return "chatroom";
	}
	
	@PostMapping("/channels/{channelId}")
	public String postMessageToChatroom (User user, String context,Channel channel) {
		ChatMessage recievedMessage = new ChatMessage(user, context);
		System.out.println(recievedMessage);
		return "redirect:";
	}
	
	
}

