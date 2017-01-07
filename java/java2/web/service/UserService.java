package com.java2.web.service;

import java.util.List;

import com.java2.web.entity.User;

public interface UserService {

	User getUser(long id);

	List<User> getAllUsers();

	List<User> createAllUsers(List<User> users);

	User removeUser(long id);

	User createUser(User user);

	User refreshUser(long id, User user);
	
	boolean isUserCreditial (String userName, String password);
}
