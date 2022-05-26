package com.scottAssignment.chatroom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.scottAssignment.chatroom.service.ChannelService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;

	
	/*	Figure out how to pass the user from the postRegister into this 
	 * GetMapping!!!
	 */
	@GetMapping("/channels")
	public String getWelcome(ModelMap model) {
		model.put("channels", channelService.retreiveAllChannels());
		
		return "channels";
	}
}
