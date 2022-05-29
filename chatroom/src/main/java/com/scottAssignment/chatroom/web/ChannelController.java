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
	
	
	/*
	 * This GET MApping will be MULTIFUNCTIONAL
	 * 	1) The initial landing page for all channels
	 * 	2) the Fetch request will  query this endpoint for  Messages particular
	 * 		To this channel
	 */
	@GetMapping("/channels/{channelId}")
	public String getChannelDisplay (ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.getChannelById(channelId);
		model.put("chatroom", channel);
		model.put("user", new User());
		model.put("chatMessage", new ChatMessage() );
		return "chatroom";
	}
	
	
	// THE MESSAGE MUST BE SAVED TO THE DESIGNATED CHANNEL!!!!
	
	//The TeaxtArea Message Arrives INSIDE the CHATMESSAGE OBJ assigned 
	// to the CHATMESSAGE.CONTEXT within the HTML page
	@PostMapping("/channels/{channelId}")
	public String postMessageToChatroom (@PathVariable Long channelId, User user, ChatMessage chatMessage) {
		
		// The passed user is assigned to the chatmessage as the USER who
		//		Sent it
		chatMessage.setSentBy(user);
		
		
		channelService.addMessageToChannel(channelId, chatMessage);
		
		System.out.println("printing messages");
		
		
		/*
		recievedChannel.getMessages().forEach((message) -> {
			System.out.println(message);
		});
		*/
		
		return "redirect:/channels/" + channelId;
	}
	
	
}

