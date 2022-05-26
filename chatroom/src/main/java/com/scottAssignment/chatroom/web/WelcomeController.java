package com.scottAssignment.chatroom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.scottAssignment.chatroom.domain.User;
import com.scottAssignment.chatroom.service.UserService;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserService userService;
	
	// The Initial page reached @ localhost:8080 in order to acquire a designation for
	// the user and pass it on to the POSTMAPPING where the from submits too
	@GetMapping("")
	public String getRegister(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "index";
	}

	//Receives the users designation and saves them to the UserRepository, as well as assigning 
	//	the user a unique within the REPOSITORIES save(User) method
	@PostMapping("")
	public String postRegister (User user) {
		userService.saveUser(user);
		return "redirect:/channels";
	}
	
	
}
