package com.scottAssignment.chatroom.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.scottAssignment.chatroom.domain.User;

@Controller
public class ChannelController {

	
	/*	Figure out how to pass the user from the postRegister into this 
	 * GetMapping!!!
	 */
	@GetMapping("/channels")
	public String getWelcome(ModelMap model ,User user) {
		
		return "channels";
	}
}
