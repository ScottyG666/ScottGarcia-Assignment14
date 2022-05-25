package com.scottAssignment.chatroom.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.scottAssignment.chatroom.domain.User;

@Repository
public class UserRepository {

	List<User> registeredUsers = new ArrayList<>();

	public User save(User user) {
		user.setId((long) registeredUsers.size() + 1);
		registeredUsers.add(user);
		return user;
		
	}

}
