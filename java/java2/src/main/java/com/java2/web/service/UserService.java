package com.java2.web.service;

import java.util.List;

import com.java2.web.dto.User;

public interface UserService {

	public User getUser(long id);

	public List<User> getAllUsers();
	
	public User createUser(User user);

	public List<User> createAllUser(List<User> users);
	
	public User removeUser(long id);
	
	public User refreshUser(long id, User user);
	
}
