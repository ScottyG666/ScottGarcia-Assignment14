package com.scottAssignment.chatroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottAssignment.chatroom.domain.User;
import com.scottAssignment.chatroom.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

}
