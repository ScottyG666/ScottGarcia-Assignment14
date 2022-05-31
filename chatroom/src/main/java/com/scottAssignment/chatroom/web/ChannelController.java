package com.scottAssignment.chatroom.web;

import java.util.List;

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

	//Listing all the available chat channels to the view
	@GetMapping("/channels")
	public String getChannels(ModelMap model) {
		model.put("channelsView", channelService.retreiveAllChannels());
		return "channels";
	}
	
	// Endpoint for creating an new chat channel to subsist with the original 
	@PostMapping("channels/createChannel")
	public String createAccount () {
		channelService.createNewChannel();
		return "redirect:/channels";
	}
	
	
	/*
	 * Mapping for reaching a Channel with its displayed chat messages
	 */
	@GetMapping("/channels/{channelId}")
	public String getChannelDisplay (ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.getChannelById(channelId);
		//Access to the channels information for populating the channel name
		model.put("channel", channel);
		//designating the messages for this particular channel
		model.put("chatroomMessages", channel.getMessages());
		//user information that is populated with JavaScript in order to submit it with FORM 
		//	POST request
		model.put("user", new User());
		//The String the user is passing within the FORM TEXTAREA to be submitted to the Chat
		model.put("chatMessage", new ChatMessage() );
		return "chatroom";
	}
	
	
	//this is the Endpoint when a User submits a message to a chat
	@PostMapping("/channels/{channelId}")
	public String postMessageToChatroom (@PathVariable Long channelId, User user, ChatMessage chatMessage) {
		
		// The passed user is assigned to the chatmessage as the USER who sent it
		chatMessage.setSentBy(user);
		channelService.addMessageToChannel(channelId, chatMessage);
		
		return "redirect:/channels/" + channelId;
	}
	
	
	//This is the endpoint JQuery reaches into to retrieve the most Up-To-Date chat messages
	//	Within the view and push them to the page without refreshing the whole html page
	@GetMapping("/channels/{channelId}/refreshChat")
	public String refreshChat (@PathVariable Long channelId, ModelMap model) {
		//Get the Associated channel and its its list of Messages
		List<ChatMessage> messages = channelService.getChannelById(channelId).getMessages();
		
		//putting the List on the view
		model.put("chatroomMessages", messages );
		
		//Designating to JQuery what view needs to be touched and what Attribute does the property
		//	we want to change reside in
		return "chatroom :: #chatWrapperDiv";
	}
	
	
	/*	
	 * 	
	@GetMapping("/channels/{channelId}/retrieveMessages")
	@ResponseBody
	public List<ChatMessage> fetchMessageForChannel (@PathVariable Long channelId) {
		return channelService.getChannelById(channelId).getMessages();
	}
	*/
}

